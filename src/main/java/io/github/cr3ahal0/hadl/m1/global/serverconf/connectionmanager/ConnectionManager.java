package io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.exception.UnknownRequestTypeException;
import io.github.cr3ahal0.hadl.m1.request.RequestType;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by Maxime on 30/11/2015.
 */
public class ConnectionManager extends Component {

    public ConnectionManager(String name) {
        super(name);

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
        if (request.getOrigin().getName().equals("Client")) {
            if (request.getService().equals(RequestType.DATABASE_AUTHENTICATION.toString())) {
                System.out.println("Transfert a request from "+ request.getOrigin().getName() + " by "+ getName() +" to "+ getProvidedPort("securityCheckProvidedPort").getName());
                getProvidedPort("securityCheckProvidedPort").onSend(request);
            }
            else if (request.getService().equals(RequestType.DATABASE_SQL_QUERY.toString())) {
                System.out.println("Transfert a request from "+ request.getOrigin().getName() + " by "+ getName() +" to "+ getProvidedPort("dbQueryProvidedPort").getName());
                getProvidedPort("dbQueryProvidedPort").onSend(request);
            }
            else {
                throw new UnknownRequestTypeException("Unknown request type");
            }
        }
    }

    @Override
    public void handleResponse(Response response) throws Exception {
        System.out.println("IMPLEMENT handleResponse(...) on "+ getName());
    }
}
