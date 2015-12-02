package io.github.cr3ahal0.hadl.m1.global.serverconf.clearancerequest;

import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 02/12/15.
 */
public class ClearanceRequestToRole extends ToRole {

    String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onSend(Request request) {

    }
}
