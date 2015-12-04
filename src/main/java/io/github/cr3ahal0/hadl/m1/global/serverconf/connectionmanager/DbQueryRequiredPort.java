package io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by Maxime on 03/12/2015.
 */
public class DbQueryRequiredPort extends RequiredPort {

    public DbQueryRequiredPort(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
