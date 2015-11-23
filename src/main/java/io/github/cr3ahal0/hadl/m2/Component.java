package io.github.cr3ahal0.hadl.m2;

import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public class Component extends AbstractComponent {

    /**
     * Set of technical constraints
     */
    private Set<String> technicalConstraints;

    /**
     * Set of RequiredPort
     */
    private Set<RequiredPort> requiredPorts;

    /**
     * Set of ProvidedPort
     */
    private Set<ProvidedPort> providedPorts;

    /**
     * Set of Service
     */
    private Set<Service> services;

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
        requiredPorts.add(requiredPort);
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
        providedPorts.add(providedPort);
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
        services.add(service);
    }

    /**
     * remove a Service
     * @param service
     */
    public void removeService(Service service) {
        services.remove(service);
    }
}
