package io.github.cr3ahal0.hadl.m2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by E130110Z on 16/11/15.
 */
public class SimpleGlue implements Observer {

    private FromRole from;

    private ToRole to;

    public SimpleGlue(FromRole from, ToRole to) {
        this.from = from;
        this.to = to;
        this.from.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        this.to.onReceive();
    }

}
