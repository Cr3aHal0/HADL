package io.github.cr3ahal0.hadl.m2.interfaces.role;

import io.github.cr3ahal0.hadl.m2.interfaces.IReceivingInterface;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class FromRole extends Role implements IReceivingInterface {

    public FromRole(String name) {
        super(name);
    }

    @Override
    public void onReceive(Request request) {
        //System.out.println("A request has been received by the Role "+ getName() +" and will be redirected.");
        System.out.println(getName() +" => ");
        setChanged();
        notifyObservers(request);
    }

    @Override
    public void onReceive(Response response) {
        //System.out.println("A response has been received by the Role "+ getName() +" and will be redirected.");
        System.out.println(getName() +" => ");
        setChanged();
        notifyObservers(response);
    }

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
