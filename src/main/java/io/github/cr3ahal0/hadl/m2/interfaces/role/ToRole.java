package io.github.cr3ahal0.hadl.m2.interfaces.role;

import io.github.cr3ahal0.hadl.m2.interfaces.ISendingInterface;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class ToRole extends Role implements ISendingInterface {

    public ToRole(String name) {
        super(name);
    }

    @Override
    public void onSend(Request request) {
        System.out.println("A request is being sent from "+ getName());
        setChanged();
        notifyObservers(request);
    }
}
