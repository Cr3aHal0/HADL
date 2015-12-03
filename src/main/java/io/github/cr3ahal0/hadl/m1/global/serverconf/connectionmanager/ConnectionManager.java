package io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager;

import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;

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

}
