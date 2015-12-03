package io.github.cr3ahal0.hadl.m2.interfaces.port;

import io.github.cr3ahal0.hadl.m2.interfaces.IReceivingInterface;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class RequiredPort extends Port implements IReceivingInterface {

    public RequiredPort(String name) {
        super(name);
    }

    public void onReceive(Request request) {
        System.out.println("A request has been received by "+ getName() +" and will be transfered to "+ getParent().getName());
        getParent().handleRequest(request);
    }

}
