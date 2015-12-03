package io.github.cr3ahal0.hadl.m1.global.clientserver.client;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientProvidedPortOne extends ProvidedPort {

    public ClientProvidedPortOne(String name) {
        super(name);
    }

    @Override
    public void onSend(Request request) {

    }

    @Override
    public String getName() {
        return name;
    }
}
