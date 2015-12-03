package io.github.cr3ahal0.hadl.m1.global.serverconf.sqlquery;

import io.github.cr3ahal0.hadl.m2.components.connector.Connector;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by Maxime on 03/12/2015.
 */
public class SqlQuery extends Connector {
    /**
     * constructor
     *
     * @param name
     */
    public SqlQuery(String name) {
        super(name);

        //From role --> [
        SqlQueryFromRole sqlQueryFromRole1 = new SqlQueryFromRole("sqlQueryFromRole1");
        //From role ] <--
        SqlQueryFromRole sqlQueryFromRole2 = new SqlQueryFromRole("sqlQueryFromRole2");
        //To role ] -->
        SqlQueryToRole sqlQueryToRole1 = new SqlQueryToRole("sqlQueryToRole1");
        //To role <-- [
        SqlQueryToRole sqlQueryToRole2 = new SqlQueryToRole("sqlQueryToRole2");

        addFromRole(sqlQueryFromRole1);
        addFromRole(sqlQueryFromRole2);
        addToRole(sqlQueryToRole1);
        addToRole(sqlQueryToRole2);
    }
}
