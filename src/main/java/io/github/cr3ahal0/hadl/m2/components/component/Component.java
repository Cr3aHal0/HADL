package io.github.cr3ahal0.hadl.m2.components.component;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m2.AbstractComponent;
import io.github.cr3ahal0.hadl.m2.ComponentKind;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.service.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class Component extends AbstractComponent {

    /**
     * Set of technical constraints
     */
    private Set<String> technicalConstraints;

    /**
     * Set of RequiredPort
     */
    private Map<String, RequiredPort> requiredPorts;

    /**
     * Set of ProvidedPort
     */
    private Map<String, ProvidedPort> providedPorts;

    /**
     * Set of Service
     */
    private Map<String, Service> services;

    public Component(String name) {
        super(name);

        technicalConstraints = new HashSet<String>();
        requiredPorts = new HashMap<String, RequiredPort>();
        providedPorts = new HashMap<String,ProvidedPort>();
        services = new HashMap<String,Service>();
    }

    public void sendRequest(Request request, ProvidedPort port) {
        //Default implementation
        port.onSend(request);
    }

    public void handleRequest(Request request) throws Exception {
        //To implement
    }

    @Override
    public ComponentKind getComponentKind() {
        return ComponentKind.COMPONENT;
    }

    /**
     * add a technicalConstraint
     * @param technicalConstraint
     */
    public void addTechnicalConstraint(String technicalConstraint) {
        technicalConstraints.add(technicalConstraint);
    }

    /**
     * remove a technicalConstraint
     * @param technicalConstraint
     */
    public void removeTechnicalConstraint(String technicalConstraint) {
        technicalConstraints.remove(technicalConstraint);
    }

    /**
     * add a RequiredPort
     * @param requiredPort
     */
    public void  addRequiredPort(RequiredPort requiredPort) {
        requiredPorts.put(requiredPort.getName(),requiredPort);
        requiredPort.setParent(this);
    }

    /**
     * remove a RequiredPort
     * @param requiredPort
     */
    public void removeRequiredPort(RequiredPort requiredPort) {
        requiredPorts.remove(requiredPort);
    }

    /**
     * add a ProvidedPort
     * @param providedPort
     */
    public void addProvidedPort(ProvidedPort providedPort) {
        providedPorts.put(providedPort.getName(), providedPort);
        providedPort.setParent(this);
    }

    /**
     * remove a ProvidedPort
     * @param providedPort
     */
    public void removeProvidedPort(ProvidedPort providedPort) {
        providedPorts.remove(providedPort);
    }

    /**
     * add a Service
     * @param service
     */
    public void addService(Service service) {
        services.put(service.getName(), service);
    }

    /**
     * remove a Service
     * @param service
     */
    public void removeService(Service service) {
        services.remove(service);
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

}
