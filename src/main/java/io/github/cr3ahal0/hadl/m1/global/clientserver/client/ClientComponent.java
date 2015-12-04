package io.github.cr3ahal0.hadl.m1.global.clientserver.client;

import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientComponent extends Component {

    public ClientComponent(String name) {
        super(name);

        ClientProvidedPortOne p1 = new ClientProvidedPortOne("cp1");
        ClientProvidedPortTwo p2 = new ClientProvidedPortTwo("cp2");

        addProvidedPort(p1);
        addProvidedPort(p2);

        ClientRequiredPortOne r1 = new ClientRequiredPortOne("cr1");
        ClientRequiredPortTwo r2 = new ClientRequiredPortTwo("cr2");

        addRequiredPort(r1);
        addRequiredPort(r2);

    }

    @Override
    public void handleResponse(Response response) throws Exception {
        System.out.println(getName() + "received response !");
    }

}
