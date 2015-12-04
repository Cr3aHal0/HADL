package io.github.cr3ahal0.hadl.m2.components.connector;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m2.AbstractComponent;
import io.github.cr3ahal0.hadl.m2.ComponentKind;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.response.Response;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public class Connector extends AbstractComponent {

    /**
     * set of FromRole
     */
    Map<String, FromRole> fromRoles;

    /**
     * set of ToRole
     */
    Map<String, ToRole> toRoles;

    /**
     * set of Glue
     */
    Set<SimpleGlue> simpleGlues;

    /**
     * constructor
     */
    public Connector(String name) {

        super(name);

        fromRoles = new HashMap<String, FromRole>();
        toRoles = new HashMap<String, ToRole>();
        simpleGlues = new HashSet<SimpleGlue>();

    }

    @Override
    public void handleRequest(Request request) {
        //Default behaviour is to let requests crossing a connector
    }

    @Override
    public void handleResponse(Response response) throws Exception {
        //Received a response
    }

    @Override
    public ComponentKind getComponentKind() {
        return ComponentKind.CONNECTOR;
    }

    /**
     * add a FromRole
     * @param fromRole a FromRole
     */
    public void addFromRole(FromRole fromRole) {
        fromRoles.put(fromRole.getName(),fromRole);
        fromRole.setParent(this);
    }

    public Map<String, FromRole> getFromRoles() {
        return fromRoles;
    }

    public FromRole getFromRole(String name) throws NonExistingInterfaceException {
        FromRole role = fromRoles.get(name);
        if (role == null) {
            throw new NonExistingInterfaceException();
        }
        return role;
    }

    /**
     * remove a FromRole
     * @param fromRole a FromRole
     */
    public void removeFromRole(FromRole fromRole) {
        fromRoles.remove(fromRole);
    }

    /**
     * add a ToRole
     * @param toRole a ToRole
     */
    public void addToRole(ToRole toRole) {
        toRoles.put(toRole.getName(),toRole);
        toRole.setParent(this);
    }

    public Map<String, ToRole> getToRoles() {
        return toRoles;
    }

    public ToRole getToRole(String name) throws NonExistingInterfaceException {
        ToRole role = toRoles.get(name);
        if (role == null) {
            throw new NonExistingInterfaceException();
        }
        return role;
    }

    /**
     * remove a ToRole
     * @param toRole a ToRole
     */
    public void removeToRole(ToRole toRole) {
        toRoles.remove(toRole);
    }

    /**
     * add a SimpleGlue
     * @param glue
     */
    public void addSimpleGlue(SimpleGlue glue) {
        simpleGlues.add(glue);
    }

    /**
     * remove a SimpleGlue
     * @param glue
     */
    public void removeSimpleGlue(SimpleGlue glue) {
        simpleGlues.remove(glue);
    }
}
