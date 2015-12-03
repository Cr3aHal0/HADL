package io.github.cr3ahal0.hadl.m1.global.serverconf.database;

import io.github.cr3ahal0.hadl.m1.global.ServiceRegistry;
import io.github.cr3ahal0.hadl.m1.global.serverconf.ExecuteQueryService;
import io.github.cr3ahal0.hadl.m2.components.component.Component;

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

}
