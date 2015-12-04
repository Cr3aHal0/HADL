package io.github.cr3ahal0.hadl.m1.global.serverconf.database;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by Maxime on 03/12/2015.
 */
public class QueryProvidedPort extends ProvidedPort {

    public QueryProvidedPort(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
