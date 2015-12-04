package io.github.cr3ahal0.hadl.m1.global.serverconf.securitymanager;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 02/12/15.
 */
public class CheckQueryProvidedPort extends ProvidedPort {


    public CheckQueryProvidedPort(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
