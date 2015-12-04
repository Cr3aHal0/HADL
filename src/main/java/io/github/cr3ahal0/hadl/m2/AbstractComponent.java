package io.github.cr3ahal0.hadl.m2;

import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class AbstractComponent {

    AbstractComponent parent;

    String name;

    public AbstractComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParent(AbstractComponent parent) {
        this.parent = parent;
    }

    public AbstractComponent getParent() {
        return this.parent;
    }

    public abstract ComponentKind getComponentKind();

    public abstract void handleRequest(Request request) throws Exception;
}
