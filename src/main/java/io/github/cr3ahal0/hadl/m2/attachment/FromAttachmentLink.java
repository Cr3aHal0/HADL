package io.github.cr3ahal0.hadl.m2.attachment;

import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.request.Request;

import java.util.Observable;

/**
 * Created by E130110Z on 16/11/15.
 */
public class FromAttachmentLink extends AttachmentLink {

    private ProvidedPort port;

    private FromRole role;

    public FromAttachmentLink(ProvidedPort port, FromRole role) {
        this.port = port;
        this.role = role;

        this.port.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        //We assume that the observable is the ProvidedPort port, just "notify" the role

        Request request = (Request)arg;
        this.role.onReceive(request);
    }
}
