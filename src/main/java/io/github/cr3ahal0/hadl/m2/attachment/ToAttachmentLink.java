package io.github.cr3ahal0.hadl.m2.attachment;

import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.response.Response;

import java.util.Observable;

/**
 * Created by E130110Z on 16/11/15.
 */
public class ToAttachmentLink extends AttachmentLink {

    private RequiredPort port;

    private ToRole role;

    protected String name;

    public ToAttachmentLink(String name, ToRole role, RequiredPort port) {
        this.name = name;
        this.role = role;
        this.port = port;

        this.role.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(getName() +" => ");
        if (arg instanceof Request) {
            this.port.onReceive((Request) arg);
        }
        else if (arg instanceof Response) {
            this.port.onReceive((Response) arg);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
