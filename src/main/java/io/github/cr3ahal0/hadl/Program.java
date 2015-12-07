package io.github.cr3ahal0.hadl;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.GlobalConfiguration;
import io.github.cr3ahal0.hadl.m1.global.clientserver.ClientServerConfiguration;
import io.github.cr3ahal0.hadl.m1.global.clientserver.client.ClientComponent;
import io.github.cr3ahal0.hadl.m1.request.RequestType;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 23/11/15.
 */
public class Program {

    public static void main(String[] args) {
        try {
            GlobalConfiguration gc = new GlobalConfiguration("Global configuration");

            ClientServerConfiguration csc = (ClientServerConfiguration)gc.getComponent("ClientServerConfiguration");

            ClientComponent cc = (ClientComponent)csc.getComponent("Client");
            Request request = new Request(cc, null, RequestType.DATABASE_SQL_QUERY.toString());
            request.setCredentialsUsername("maxime");
            request.setCredentialsPassword("mypassword");

            cc.sendRequest(request, cc.getProvidedPort("cp1"));

        } catch (NonExistingInterfaceException e) {
            e.printStackTrace();
        }
    }

}
