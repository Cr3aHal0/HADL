package io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager;

import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;

/**
 * Created by Maxime on 30/11/2015.
 */
public class ConnectionManager extends Component {

    public ConnectionManager(String name) {
        super(name);

        SecurityCheckProvidedPort securityCheckProvidedPort = new SecurityCheckProvidedPort();
        SecurityCheckRequiredPort securityCheckRequiredPort = new SecurityCheckRequiredPort();

        this.addProvidedPort(securityCheckProvidedPort);
        this.addRequiredPort(securityCheckRequiredPort);
    }

}
