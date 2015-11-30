package io.github.cr3ahal0.hadl.m2;

import java.util.List;
import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public class Configuration extends AbstractComponent {


    /**
     * Set of RequiredPort
     */
    private Set<RequiredPort> requiredPorts;

    /**
     * Set of ProvidedPort
     */
    private Set<ProvidedPort> providedPorts;

    /**
     * Set of AbstractComponent (Configuration, Connector, Component)
     */
    private Set<AbstractComponent> components;

    /**
     * Set of RequiredBindingLink (from the configuration to the internal component)
     */
    private Set<RequiredBindingLink> requiredBindings;

    /**
     * Set of ProvidedBindingLink (from the internal component to the configuration)
     */
    private Set<ProvidedBindingLink> providedBindings;

    /**
     * Set of AttachmentLink
     */
    private Set<AttachmentLink> attachments;


    /**
     * add a RequiredPort
     * @param requiredPort RequiredPort
     */
    public void addRequiredPort(RequiredPort requiredPort) {
        requiredPorts.add(requiredPort);
    }

    /**
     * remove a RequiredPort
     * @param requiredPort RequiredPort
     */
    public void removeRequiredPort(RequiredPort requiredPort) {
        requiredPorts.remove(requiredPort);
    }

    /**
     * add a ProvidedPort
     * @param providedPort ProvidedPort
     */
    public void addProvidedPort(ProvidedPort providedPort) {
        providedPorts.add(providedPort);
    }

    /**
     * remove a ProvidedPort
     * @param providedPort ProvidedPort
     */
    public void removeProvidedPort(ProvidedPort providedPort) {
        providedPorts.remove(providedPort);
    }

    /**
     * add an AbstractComponent
     * @param component AbstractComponent
     */
    public void addComponent(AbstractComponent component) {
        this.components.add(component);
    }

    /**
     * remove an AbstractComponent
     * @param component AbstractComponent
     */
    public void removeComponent(AbstractComponent component) {
        this.components.remove(component);
    }

    /**
     * add a RequiredBindingLink
     * @param binding RequiredBindingLink
     */
    public void addRequiredBindingLink(RequiredBindingLink binding) {
        this.requiredBindings.add(binding);
    }

    /**
     * remove a RequiredBindingLink
     * @param binding RequiredBindingLink
     */
    public void removeRequiredBindingLink(RequiredBindingLink binding) {
        this.requiredBindings.remove(binding);
    }

    /**
     * add a ProvidedBindingLink
     * @param binding ProvidedBindingLink
     */
    public void addProvidedBindingLink(ProvidedBindingLink binding) {
        this.providedBindings.add(binding);
    }

    /**
     * add a ProvidedBindingLink
     * @param binding ProvidedBindingLink
     */
    public void removeProvidedBindingLink(ProvidedBindingLink binding) {
        this.providedBindings.add(binding);
    }

    /**
     * Add an AttachmentLink
     * @param attachment AttachmentLink
     */
    public void addAttachmentLink(AttachmentLink attachment) {
        this.attachments.add(attachment);
    }

    /**
     * remove an AttachmentLink
     * @param attachment AttachmentLink
     */
    public void removeAttachmentLink(AttachmentLink attachment) {
        this.attachments.remove(attachment);
    }

    public Set<RequiredPort> getRequiredPorts() {
        return requiredPorts;
    }

    public Set<ProvidedPort> getProvidedPorts() {
        return providedPorts;
    }

    public Set<AbstractComponent> getComponents() {
        return components;
    }

    public Set<RequiredBindingLink> getRequiredBindings() {
        return requiredBindings;
    }

    public Set<ProvidedBindingLink> getProvidedBindings() {
        return providedBindings;
    }

    public Set<AttachmentLink> getAttachments() {
        return attachments;
    }

}
