package io.github.cr3ahal0.hadl;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.GlobalConfiguration;
import io.github.cr3ahal0.hadl.m1.global.clientserver.ClientServerConfiguration;
import io.github.cr3ahal0.hadl.m1.global.clientserver.client.ClientComponent;

/**
 * Created by E130110Z on 23/11/15.
 */
public class Program {

    public static void main(String[] args) {
        try {
            GlobalConfiguration gc = new GlobalConfiguration("Global configuration");

            ClientServerConfiguration csc = (ClientServerConfiguration)gc.getComponent("ClientServerConfiguration");

            ClientComponent cc = (ClientComponent)csc.getComponent("Client");

        } catch (NonExistingInterfaceException e) {
            e.printStackTrace();
        }
    }

}
