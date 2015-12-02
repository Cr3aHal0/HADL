package io.github.cr3ahal0.hadl.m1.global.connector;

import io.github.cr3ahal0.hadl.m2.components.connector.Connector;

/**
 * Created by E130110Z on 02/12/15.
 */
public class ClientServerToServerConf extends Connector {
    /**
     * constructor
     *
     * @param name
     */
    public ClientServerToServerConf(String name) {
        super(name);

        addFromRole(new ClientServerFromRole());
        addFromRole(new ServerConfFromRole());

        addToRole(new ClientServerToRole());
        addToRole(new ServerConfToRole());

    }
}
