package io.github.cr3ahal0.hadl.m2.interfaces.port;

import io.github.cr3ahal0.hadl.m2.ComponentKind;
import io.github.cr3ahal0.hadl.m2.interfaces.IReceivingInterface;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class RequiredPort extends Port implements IReceivingInterface {

    public RequiredPort(String name) {
        super(name);
    }

    @Override
    public void onReceive(Request request) {
        if (getParent().getComponentKind().equals(ComponentKind.COMPONENT)) {
            System.out.println("A request has been received by "+ getName() +" and will be transfered to "+ getParent().getName());
            try {
                getParent().handleRequest(request);
            } catch (Exception e) {
                System.out.println("/!\\ An error occured while trying to transfer a request from "+ getName() +" to "+ getParent().getName());
                e.printStackTrace();
            }
        }
        else if (getParent().getComponentKind().equals(ComponentKind.CONFIGURATION))
        {
            System.out.println("A request has been received by "+ getName() +" and will be transfered to the appropriate binded port");
            setChanged();
            notifyObservers(request);
        }
    }

    @Override
    public void onReceive(Response response) {
        if (getParent().getComponentKind().equals(ComponentKind.COMPONENT)) {
            System.out.println("A response has been received by "+ getName() +" and will be transfered to "+ getParent().getName());
            try {
                getParent().handleResponse(response);
            } catch (Exception e) {
                System.out.println("/!\\ An error occured while trying to transfer a response from "+ getName() +" to "+ getParent().getName());
                e.printStackTrace();
            }
        }
        else if (getParent().getComponentKind().equals(ComponentKind.CONFIGURATION))
        {
            System.out.println("A response has been received by "+ getName() +" and will be transfered to the appropriate binded port");
            setChanged();
            notifyObservers(response);
        }
    }

}
