package io.github.cr3ahal0.hadl.m1.global.clientserver.server;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerProvidedPortOne extends ProvidedPort {

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
