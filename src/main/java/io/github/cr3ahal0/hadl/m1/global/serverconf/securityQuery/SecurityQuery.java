package io.github.cr3ahal0.hadl.m1.global.serverconf.securityQuery;

import io.github.cr3ahal0.hadl.m2.components.connector.Connector;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by Maxime on 03/12/2015.
 */
public class SecurityQuery extends Connector {
    /**
     * constructor
     *
     * @param name
     */
    public SecurityQuery(String name) {
        super(name);

        SecurityQueryFromRole securityQueryFromRole1 = new SecurityQueryFromRole("securityQueryFromRole1");
        addFromRole(securityQueryFromRole1);
        //From role ] <--
        SecurityQueryFromRole securityQueryFromRole2 = new SecurityQueryFromRole("securityQueryFromRole2");
        addFromRole(securityQueryFromRole2);
        //To role ] -->
        SecurityQueryToRole securityQueryToRole1 = new SecurityQueryToRole("securityQueryToRole1");
        addToRole(securityQueryToRole1);
        //To role <-- [
        SecurityQueryToRole securityQueryToRole2 = new SecurityQueryToRole("securityQueryToRole2");
        addToRole(securityQueryToRole2);
    }
}
