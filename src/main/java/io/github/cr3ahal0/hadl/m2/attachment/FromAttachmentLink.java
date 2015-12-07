package io.github.cr3ahal0.hadl.m2.attachment;

import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

import java.util.Observable;

/**
 * Created by E130110Z on 16/11/15.
 */
public class FromAttachmentLink extends AttachmentLink {

    private ProvidedPort port;

    private FromRole role;

    protected String name;

    public FromAttachmentLink(String name, ProvidedPort port, FromRole role) {
        this.name = name;
        this.port = port;
        this.role = role;

        this.port.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        //We assume that the observable is the ProvidedPort port, just "notify" the role

        System.out.println(getName() +" => ");
        if (arg instanceof Request) {
            Request request = (Request) arg;
            this.role.onReceive(request);
        }
        else if (arg instanceof Response) {
            Response response = (Response) arg;
            this.role.onReceive(response);
        }

    }

    @Override
    public String getName() {
        return name;
    }
}
