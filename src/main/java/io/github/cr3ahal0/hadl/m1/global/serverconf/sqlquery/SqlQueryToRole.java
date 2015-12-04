package io.github.cr3ahal0.hadl.m1.global.serverconf.sqlquery;

import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by Maxime on 03/12/2015.
 */
public class SqlQueryToRole extends ToRole {

    public SqlQueryToRole(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
