package io.github.cr3ahal0.hadl.m2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public class Connector extends AbstractComponent {

    /**
     * set of FromRole
     */
    Set<FromRole> fromRoles;

    /**
     * set of ToRole
     */
    Set<ToRole> toRoles;

    /**
     * set of Glue
     */
    Set<SimpleGlue> simpleGlues;

    /**
     * constructor
     */
    public Connector(String name) {

        super(name);

        fromRoles = new HashSet<FromRole>();
        toRoles = new HashSet<ToRole>();
        simpleGlues = new HashSet<SimpleGlue>();

    }

    @Override
    public boolean handleRequest(Request request) throws Exception {
        //Default behaviour is to let requests crossing a connector
        return false;
    }

    /**
     * add a FromRole
     * @param fromRole a FromRole
     */
    public void addFromRole(FromRole fromRole) {
        fromRoles.add(fromRole);
        fromRole.setParent(this);
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
        toRoles.add(toRole);
        toRole.setParent(this);
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
