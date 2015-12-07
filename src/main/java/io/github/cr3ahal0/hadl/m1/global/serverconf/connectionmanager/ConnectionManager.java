package io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.exception.UnknownRequestTypeException;
import io.github.cr3ahal0.hadl.m1.request.RequestType;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.components.configuration.Configuration;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.request.RequestKind;
import io.github.cr3ahal0.hadl.m2.response.Response;
import io.github.cr3ahal0.hadl.m2.response.ResponseCode;

import java.util.HashMap;

/**
 * Created by Maxime on 30/11/2015.
 */
public class ConnectionManager extends Component {

    private final HashMap<Request, Request> pendingRequests;

    public ConnectionManager(String name) {
        super(name);

        pendingRequests = new HashMap<Request, Request>();

        SecurityCheckProvidedPort securityCheckProvidedPort = new SecurityCheckProvidedPort("securityCheckProvidedPort");
        SecurityCheckRequiredPort securityCheckRequiredPort = new SecurityCheckRequiredPort("securityCheckRequiredPort");

        this.addProvidedPort(securityCheckProvidedPort);
        this.addRequiredPort(securityCheckRequiredPort);

        ExternalSocketProvidedPort externalSocketProvidedPort = new ExternalSocketProvidedPort("externalSocketProvidedPort");
        ExternalSocketRequiredPort externalSocketRequiredPort = new ExternalSocketRequiredPort("externalSocketRequiredPort");

        addProvidedPort(externalSocketProvidedPort);
        addRequiredPort(externalSocketRequiredPort);

        DbQueryProvidedPort dbQueryProvidedPort = new DbQueryProvidedPort("dbQueryProvidedPort");
        DbQueryRequiredPort dbQueryRequiredPort = new DbQueryRequiredPort("dbQueryRequiredPort");

        addProvidedPort(dbQueryProvidedPort);
        addRequiredPort(dbQueryRequiredPort);
    }

    @Override
    public void handleRequest(Request request) throws UnknownRequestTypeException, NonExistingInterfaceException {
        //TO implement
        System.out.println(getName() +" => ");
        if (request.getOrigin().getName().equals("Client")) {
            /*if (request.getService().equals(RequestType.DATABASE_AUTHENTICATION.toString())) {
                System.out.println("Transfert a request from "+ request.getOrigin().getName() + " by "+ getName() +" to "+ getProvidedPort("securityCheckProvidedPort").getName());
                getProvidedPort("securityCheckProvidedPort").onSend(request);
            }
            else*/
            if (request.getService().equals(RequestType.DATABASE_SQL_QUERY.toString())) {
                /*
                    System.out.println("Transfert a request from "+ request.getOrigin().getName() + " by "+ getName() +" to "+ getProvidedPort("dbQueryProvidedPort").getName());
                    getProvidedPort("dbQueryProvidedPort").onSend(request);
                */
                //First ask the SecurityManager if the current user is allowed
                Request authRequest = new Request(this, null, RequestType.DATABASE_AUTHENTICATION.toString(), RequestKind.SYNCHRONEOUS);
                authRequest.setCredentialsUsername(request.getCredentialsUsername());
                authRequest.setCredentialsPassword(request.getCredentialsPassword());

                pendingRequests.put(authRequest, request);

                sendRequest(authRequest, getProvidedPort("securityCheckProvidedPort"));
            }
            else {
                throw new UnknownRequestTypeException("Unknown request type");
            }
        }
    }

    @Override
    public void handleResponse(Response response) throws Exception {
        super.handleResponse(response);

        //System.out.println("A response has been received by "+ getName() +" with code "+ response.getCode() +" for service "+ response.getRequest().getService());

        System.out.println(getName() +" => ");
        //if the response is about verifying crendentials
        if (response.getRequest().getService().equals(RequestType.DATABASE_AUTHENTICATION.toString())) {

            //If it has failed
            if (!response.getCode().equals(ResponseCode.OK)) {

                //There must be a pending request
                Request pendingRequest = pendingRequests.get(response.getRequest());

                //Build a response for this request and send it back
                Response pendingResponse = new Response(pendingRequest);
                pendingResponse.setCode(response.getCode());

                sendResponse(pendingResponse, getProvidedPort("externalSocketProvidedPort"));
            }
            else
            {
                //The user has been specifically authorized by the SecurityManager, we can now send request to the database
                Request dbRequest = new Request(this, null, RequestType.DATABASE_SQL_QUERY.toString(), RequestKind.SYNCHRONEOUS);
                pendingRequests.put(dbRequest, null);
                sendRequest(dbRequest, getProvidedPort("dbQueryProvidedPort"));
            }

        }
        //else if it is about the database query
        else if (response.getRequest().getService().equals(RequestType.DATABASE_SQL_QUERY.toString())) {
            //There must be a pending request
            Request pendingRequest = pendingRequests.get(response.getRequest());

            //Build a response for this request and send it back
            Response pendingResponse = new Response(pendingRequest);
            pendingResponse.setCode(response.getCode());
            pendingResponse.setData(response.getData());

            sendResponse(pendingResponse, getProvidedPort("externalSocketProvidedPort"));
        }
    }
}
