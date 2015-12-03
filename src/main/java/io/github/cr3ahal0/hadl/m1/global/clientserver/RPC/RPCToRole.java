package io.github.cr3ahal0.hadl.m1.global.clientserver.RPC;

import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 23/11/15.
 */
public class RPCToRole extends ToRole {


    public RPCToRole(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
