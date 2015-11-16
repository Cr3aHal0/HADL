package io.github.cr3ahal0.hadl.m2;

import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public class Component extends AbstractComponent {

    private Set<String> technicalConstraints;

    private Set<RequiredPort> requiredPorts;

    private Set<ProvidedPort> providedPorts;

    private Set<Service> services;

}
