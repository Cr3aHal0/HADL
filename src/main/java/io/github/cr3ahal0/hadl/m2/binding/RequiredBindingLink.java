package io.github.cr3ahal0.hadl.m2.binding;

import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.response.Response;

import java.util.Observable;

/**
 * Created by E130110Z on 23/11/15.
 */
public class RequiredBindingLink extends BindingLink {

    /**
     * the RequiredPort from the configuration
     */
    RequiredPort configurationRequiredPort;

    /**
     * the RequiredPort from the internal component
     */
    RequiredPort componentRequiredPort;

    public RequiredBindingLink(RequiredPort configurationRequiredPort, RequiredPort componentRequiredPort) {
        this.configurationRequiredPort = configurationRequiredPort;
        this.componentRequiredPort = componentRequiredPort;

        this.configurationRequiredPort.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println(("binding => "));
        if (o instanceof Request) {
            this.componentRequiredPort.onReceive((Request) o);
        }
        else if (o instanceof Response) {
            this.componentRequiredPort.onReceive((Response) o);
        }
    }
}
