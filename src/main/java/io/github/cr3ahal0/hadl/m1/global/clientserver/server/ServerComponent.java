package io.github.cr3ahal0.hadl.m1.global.clientserver.server;

import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerComponent extends Component {

    public ServerComponent(String name) {
        super(name);

        RequiredPort r1 = new ServerRequiredPortOne();
        RequiredPort r2 = new ServerRequiredPortTwo();

        addRequiredPort(r1);
        addRequiredPort(r2);

        ProvidedPort p1 = new ServerProvidedPortOne();
        ProvidedPort p2 = new ServerProvidedPortTwo();

        addProvidedPort(p1);
        addProvidedPort(p2);

    }
}
