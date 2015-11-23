package io.github.cr3ahal0.hadl.m2;

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
    }

}
