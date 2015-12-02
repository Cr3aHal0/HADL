package io.github.cr3ahal0.hadl.m2.interfaces;

import io.github.cr3ahal0.hadl.m2.AbstractComponent;
import io.github.cr3ahal0.hadl.m2.INamedElement;
import io.github.cr3ahal0.hadl.m2.request.Request;

import java.util.Observable;

/**
 * Created by E130110Z on 02/12/15.
 */
public abstract class Interface extends Observable implements INamedElement {

    private AbstractComponent parent;

    public void setParent(AbstractComponent parent) {
        this.parent = parent;
    }

    protected AbstractComponent getParent() {
        return this.parent;
    }

}