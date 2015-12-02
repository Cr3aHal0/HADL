package io.github.cr3ahal0.hadl.m1.global.clientserver.configuration;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 02/12/15.
 */
public class ConfRequiredPort extends RequiredPort {

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
    public void onReceive(Request request) {

    }
}
