package io.github.cr3ahal0.hadl.m2.interfaces.port;

import io.github.cr3ahal0.hadl.m2.interfaces.ISendingInterface;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class ProvidedPort extends Port implements ISendingInterface {
    public ProvidedPort(String name) {
        super(name);
    }

    @Override
    public void onSend(Request request) {
        System.out.println(getName() +" => ");
        //System.out.println("A request has been received and will be sent by "+ getName());
        this.setChanged();
        this.notifyObservers(request);
    }

    @Override
    public void onSend(Response response) {
        System.out.println(getName() +" => ");
        //System.out.println("A response has been received and will be sent by "+ getName());
        this.setChanged();
        this.notifyObservers(response);
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
