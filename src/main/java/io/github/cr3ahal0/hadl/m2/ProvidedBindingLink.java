package io.github.cr3ahal0.hadl.m2;

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
    }

}
