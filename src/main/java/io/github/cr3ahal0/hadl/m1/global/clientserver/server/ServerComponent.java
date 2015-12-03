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

        RequiredPort r1 = new ServerRequiredPortOne("sr1");
        RequiredPort r2 = new ServerRequiredPortTwo("sr2");

        addRequiredPort(r1);
        addRequiredPort(r2);

        ProvidedPort p1 = new ServerProvidedPortOne("sp1");
        ProvidedPort p2 = new ServerProvidedPortTwo("sp2");

        addProvidedPort(p1);
        addProvidedPort(p2);

    }
}
