package io.github.cr3ahal0.hadl.m1.global.clientserver.server;

import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerRequiredPortOne extends RequiredPort {

    public ServerRequiredPortOne(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
