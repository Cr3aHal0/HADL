package io.github.cr3ahal0.hadl.m2.components.connector;

import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

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
        System.out.println("Glue => ");
        //System.out.println("[Glue]Receiving request from "+ from.getName() +" and redirecting it to "+ to.getName());
        if (o instanceof Request) {
            this.to.onSend((Request) o);
        }
        else if (o instanceof Response) {
            this.to.onSend((Response) o);
        }
    }

}
