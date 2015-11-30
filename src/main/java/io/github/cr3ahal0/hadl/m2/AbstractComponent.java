package io.github.cr3ahal0.hadl.m2;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class AbstractComponent {

    String name;

    public AbstractComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean handleRequest(Request request) throws Exception;
}
