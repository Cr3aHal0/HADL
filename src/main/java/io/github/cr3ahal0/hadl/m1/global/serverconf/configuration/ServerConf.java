package io.github.cr3ahal0.hadl.m1.global.serverconf.configuration;

import io.github.cr3ahal0.hadl.m2.components.configuration.Configuration;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;

/**
 * Created by E130110Z on 02/12/15.
 */
public class ServerConf extends Configuration {

    public ServerConf(String name) {

        super(name);

        ProvidedPort serverConfProvidedPort = new ServerConfProvidedPort("serverConfProvidedPort");
        RequiredPort serverConfRequiredPort = new ServerConfRequiredPort("serverConfRequiredPort");
        addProvidedPort(serverConfProvidedPort);
        addRequiredPort(serverConfRequiredPort);

    }

}
