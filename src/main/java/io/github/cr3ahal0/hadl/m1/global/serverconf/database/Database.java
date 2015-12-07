package io.github.cr3ahal0.hadl.m1.global.serverconf.database;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.ServiceRegistry;
import io.github.cr3ahal0.hadl.m1.global.serverconf.ExecuteQueryService;
import io.github.cr3ahal0.hadl.m1.request.RequestType;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;
import io.github.cr3ahal0.hadl.m2.response.ResponseCode;

/**
 * Created by Maxime on 30/11/2015.
 */
public class Database extends Component {

    public Database(String name) {
        super(name);

        addProvidedPort(new SecurityManagementProvidedPort("securityManagementProvidedPort"));
        addRequiredPort(new SecurityManagementRequiredPort("securityManagementRequiredPort"));

        addProvidedPort(new QueryProvidedPort("queryProvidedPort"));
        addRequiredPort(new QueryRequiredPort("queryRequiredPort"));

        ExecuteQueryService service = new ExecuteQueryService("ExecuteQueryService");
        addService(service);

        //expose this service to the service registry
        ServiceRegistry.register(service.getName(), this);
    }

    @Override
    public void handleRequest(Request request) throws NonExistingInterfaceException {

        //System.out.println("A request has been received by "+ getName() +" from "+ request.getOrigin().getName() + " for service "+ request.getService());
        System.out.println(getName() +" => END");
        if (request.getService().equals(RequestType.DATABASE_SQL_QUERY.toString())) {

            Response queryResponse = new Response(request);
            queryResponse.setCode(ResponseCode.OK);
            queryResponse.setData("Mr JACQUES Michel");

            sendResponse(queryResponse, getProvidedPort("queryProvidedPort"));
        }

    }

    @Override
    public void handleResponse(Response response) throws Exception {
        System.out.println("IMPLEMENT handleResponse(...) on "+ getName());
    }
}
