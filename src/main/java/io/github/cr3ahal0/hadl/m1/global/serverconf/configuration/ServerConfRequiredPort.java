package io.github.cr3ahal0.hadl.m1.global.serverconf.configuration;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by Maxime on 03/12/2015.
 */
public class ServerConfRequiredPort extends RequiredPort {

    public ServerConfRequiredPort(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onReceive(Request request) {

    }
}
