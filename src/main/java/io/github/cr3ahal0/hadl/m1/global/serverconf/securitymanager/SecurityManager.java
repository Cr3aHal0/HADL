package io.github.cr3ahal0.hadl.m1.global.serverconf.securitymanager;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.exception.UnknownRequestTypeException;
import io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager.SecurityCheckProvidedPort;
import io.github.cr3ahal0.hadl.m1.request.RequestType;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;
import io.github.cr3ahal0.hadl.m2.response.ResponseCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maxime on 30/11/2015.
 */
public class SecurityManager extends Component{

    Map<String, String> allowed;

    public SecurityManager(String name) {
        super(name);

        allowed = new HashMap<String, String>();
        allowed.put("maxime", "mypassword");

        SecurityAuthProvidedPort c1 = new SecurityAuthProvidedPort("securityAuthProvidedPort");
        CheckQueryProvidedPort c2 = new CheckQueryProvidedPort("checkQueryProvidedPort");

        SecurityAuthRequiredPort c3 = new SecurityAuthRequiredPort("securityAuthRequiredPort");
        CheckQueryRequiredPort c4 = new CheckQueryRequiredPort("checkQueryRequiredPort");

        addProvidedPort(c1);
        addProvidedPort(c2);
        addRequiredPort(c3);
        addRequiredPort(c4);
    }

    @Override
    public void handleRequest(Request request) throws UnknownRequestTypeException, NonExistingInterfaceException {
        System.out.println(getName() +" Handling a request !");
        if (request.getService().equals(RequestType.DATABASE_AUTHENTICATION.toString())) {
            Response response = new Response(request);
            if (allowed.get(request.getCredentialsUsername()) != null && allowed.get(request.getCredentialsUsername()).equals(request.getCredentialsPassword())) {
                response.setCode(ResponseCode.OK);
            }
            else
            {
                response.setCode(ResponseCode.UNAUTHORIZED);
            }
            sendResponse(response, getProvidedPort("securityAuthProvidedPort"));
        }
        else
        {
            throw new UnknownRequestTypeException(request.getService());
        }
    }

    @Override
    public void handleResponse(Response response) throws Exception {
        System.out.println("IMPLEMENT handleResponse(...) on "+ getName());
    }

}
