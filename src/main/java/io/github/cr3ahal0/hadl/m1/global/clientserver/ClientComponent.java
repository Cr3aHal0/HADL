package io.github.cr3ahal0.hadl.m1.global.clientserver;

import io.github.cr3ahal0.hadl.m2.Component;
import io.github.cr3ahal0.hadl.m2.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.RequiredPort;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientComponent extends Component {

    public ClientComponent() {

        ProvidedPort p1 = new ProvidedPort();
        ProvidedPort p2 = new ProvidedPort();

        addProvidedPort(p1);
        addProvidedPort(p2);

    }

}
