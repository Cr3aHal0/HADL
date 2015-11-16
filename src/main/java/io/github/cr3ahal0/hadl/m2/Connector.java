package io.github.cr3ahal0.hadl.m2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by E130110Z on 16/11/15.
 */
public class Connector extends AbstractComponent {

    Set<FromRole> fromRoles;

    Set<ToRole> toRoles;


    public Connector() {

        fromRoles = new HashSet<FromRole>();
        toRoles = new HashSet<ToRole>();

    }

}
