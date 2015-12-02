package io.github.cr3ahal0.hadl.m1.global.clientserver.RPC;

import io.github.cr3ahal0.hadl.m2.components.connector.Connector;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by E130110Z on 23/11/15.
 */
public class RPCConnector extends Connector {

    public RPCConnector(String name) {
        super(name);

        FromRole f1 = new RPCFromRole();
        FromRole f2 = new RPCFromRole();
        ToRole t1 = new RPCToRole();
        ToRole t2 = new RPCToRole();

        addToRole(t1);
        addToRole(t2);
        addFromRole(f1);
        addFromRole(f2);
    }

}
