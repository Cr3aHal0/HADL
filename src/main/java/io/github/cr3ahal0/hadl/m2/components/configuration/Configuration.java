package io.github.cr3ahal0.hadl.m2.components.configuration;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.ServiceRegistry;
import io.github.cr3ahal0.hadl.m2.AbstractComponent;
import io.github.cr3ahal0.hadl.m2.ComponentKind;
import io.github.cr3ahal0.hadl.m2.attachment.AttachmentLink;
import io.github.cr3ahal0.hadl.m2.binding.ProvidedBindingLink;
import io.github.cr3ahal0.hadl.m2.binding.RequiredBindingLink;
import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.exception.NoSuchServiceException;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class Configuration extends AbstractComponent {


    /**
     * Set of RequiredPort
     */
    private Map<String, RequiredPort> requiredPorts;

    /**
     * Set of ProvidedPort
     */
    private Map<String, ProvidedPort> providedPorts;

    /**
     * Set of AbstractComponent (Configuration, Connector, Component)
     */
    private Map<String, AbstractComponent> components;

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

    public Configuration(String name) {
        super(name);

        requiredPorts = new HashMap<String, RequiredPort>();
        providedPorts = new HashMap<String, ProvidedPort>();
        components = new HashMap<String, AbstractComponent>();
        requiredBindings = new HashSet<RequiredBindingLink>();
        providedBindings = new HashSet<ProvidedBindingLink>();
        attachments = new HashSet<AttachmentLink>();
    }

    @Override
    public void handleRequest(Request request) {
        //Default behaviour is to let requests crossing a connector
    }

    @Override
    public void handleResponse(Response request) {
        //Default behaviour is to let responses crossing a connector
    }

    @Override
    public ComponentKind getComponentKind() {
        return ComponentKind.CONFIGURATION;
    }

    /**
     * add a RequiredPort
     * @param requiredPort RequiredPort
     */
    public void addRequiredPort(RequiredPort requiredPort) {
        requiredPorts.put(requiredPort.getName(), requiredPort);
        requiredPort.setParent(this);
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
        providedPorts.put(providedPort.getName(), providedPort);
        providedPort.setParent(this);
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
        this.components.put(component.getName(), component);
        component.setParent(this);
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

    public Map<String, RequiredPort> getRequiredPorts() {
        return requiredPorts;
    }

    public RequiredPort getRequiredPort(String name) throws NonExistingInterfaceException {
        RequiredPort port = requiredPorts.get(name);
        if (port == null) {
            throw new NonExistingInterfaceException();
        }
        return port;
    }

    public Map<String, ProvidedPort> getProvidedPorts() {
        return providedPorts;
    }

    public ProvidedPort getProvidedPort(String name) throws NonExistingInterfaceException {
        ProvidedPort port = providedPorts.get(name);
        if (port == null) {
            throw new NonExistingInterfaceException();
        }
        return port;
    }

    public Map<String, AbstractComponent> getComponents() {
        return components;
    }

    public AbstractComponent getComponent(String name) throws NonExistingInterfaceException{
        AbstractComponent component = components.get(name);
        if (component == null) {
            throw new NonExistingInterfaceException();
        }
        return component;
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

    /**
     * Returns what port should be used to verify the route to the given service name
     * @param serviceName the name of the service to reach
     * @return the port to contact
     */
    public Configuration getConfigurationOwningService(String serviceName) throws NoSuchServiceException {
        Configuration togo = null;

        //First, check if we know the service as a local service
        Component component = ServiceRegistry.find(serviceName);
        if (component == null) {
            throw new NoSuchServiceException();
        }

        return (Configuration)component.getParent();
    }

    /*
     - WIP -
    public void getRouteForService(String serviceName) throws NoSuchServiceException {
        Configuration config = getConfigurationOwningService(serviceName);

        //if the targeted configuration is not the current configuration, find the component to contact
        if (!config.getName().equals(getName())) {

        }
    }
    */
}
