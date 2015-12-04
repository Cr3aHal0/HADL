package io.github.cr3ahal0.hadl.m1.global.clientserver.server;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.request.RequestType;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

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

    @Override
    public void handleRequest(Request request) {

        System.out.println("Handling a request from "+ request.getOrigin().getName() +" at "+ getName());
        if (request.getOrigin().getName().equals("Client")) {
            if (request.getService().equals(RequestType.DATABASE_AUTHENTICATION.toString()) ||
                request.getService().equals(RequestType.DATABASE_SQL_QUERY.toString())) {

                //If this is a specific service, transfer it to the Internal Server Configuration
                try {
                    System.out.println("Transfert a request from "+ request.getOrigin().getName() + " by "+ getName() +" to "+ getProvidedPort("sp2").getName());
                    getProvidedPort("sp2").onSend(request);
                } catch (NonExistingInterfaceException e) {
                    System.out.println("Unable to transfert request by "+ getName());
                }

            }
        }
    }

}
