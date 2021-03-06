package io.github.cr3ahal0.hadl.m2.binding;

import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.response.Response;

import java.util.Observable;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ProvidedBindingLink extends BindingLink {

    /**
     * the RequiredPort from the configuration
     */
    ProvidedPort configurationProvidedPort;

    /**
     * the RequiredPort from the internal component
     */
    ProvidedPort componentProvidedPort;

    public ProvidedBindingLink(ProvidedPort configurationProvidedPort, ProvidedPort componentProvidedPort) {
        this.configurationProvidedPort = configurationProvidedPort;
        this.componentProvidedPort = componentProvidedPort;

        this.componentProvidedPort.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Binding => ");
        if (o instanceof Request) {
            this.configurationProvidedPort.onSend((Request) o);
        }
        else if (o instanceof Response) {
            this.configurationProvidedPort.onSend((Response) o);
        }

    }

}
