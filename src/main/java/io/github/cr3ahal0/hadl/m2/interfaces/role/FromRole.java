package io.github.cr3ahal0.hadl.m2.interfaces.role;

import io.github.cr3ahal0.hadl.m2.interfaces.IReceivingInterface;
import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class FromRole extends Role implements IReceivingInterface {


    /*
    @Override
    public void onReceive(Request request) {
        //Useless for asynchroneous request
        if (request.isSynchroneous()) {
            request.addStep(this);
        }

        System.out.println("A request has reached "+ this.getClass().getName() +"!");

        //Did we just reach the target ?
        try {
            if (getParent().handleRequest(request)) {
                //In case we've reached the proper target, just stop there and initiate the come back
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Parent unable to handle request");
        }

        notifyObservers(request);
    }
    */
}
