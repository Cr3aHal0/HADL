package io.github.cr3ahal0.hadl.m1.global;

import io.github.cr3ahal0.hadl.m2.components.component.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by E130110Z on 30/11/15.
 */
public class ServiceRegistry {

    private static Map<String, Component> services;

    static {
        Map<String, Component> services = new HashMap<String, Component>();
    }

    private ServiceRegistry() {}

    public static Component find(String service) {
        return services.get(service);
    }

    public static boolean register(String service, Component component) {
        Component result = services.get(service);
        if (result == null) {
            services.put(service, component);
            return true;
        }
        System.out.println("You have already deployed this service for component '"+ component.getName() +"'");
        return false;
    }

}
