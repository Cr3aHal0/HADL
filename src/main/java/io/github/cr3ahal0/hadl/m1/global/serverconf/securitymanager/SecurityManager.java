package io.github.cr3ahal0.hadl.m1.global.serverconf.securitymanager;

import io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager.SecurityCheckProvidedPort;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by Maxime on 30/11/2015.
 */
public class SecurityManager extends Component{

    public SecurityManager(String name) {
        super(name);

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
    public void handleRequest(Request request) {
        System.out.println(getName() +" Handling a request !");

    }

    @Override
    public void handleResponse(Response response) throws Exception {
        System.out.println("IMPLEMENT handleResponse(...) on "+ getName());
    }

}
