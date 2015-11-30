package io.github.cr3ahal0.hadl.m2;

import java.util.Observable;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class Interface extends Observable {

    private AbstractComponent parent;

    public void setParent(AbstractComponent parent) {
        this.parent = parent;
    }

    protected AbstractComponent getParent() {
        return this.parent;
    }

    public abstract void onReceive(Request request) throws Exception;

}
