package io.github.cr3ahal0.hadl.m2;

/**
 * Created by E130110Z on 16/11/15.
 */
public class ToRole extends Role {

    @Override
    public void onReceive(Request request) {
        //Just notify listeners as we're just made to initiate communication
        notifyObservers(request);
    }
}
