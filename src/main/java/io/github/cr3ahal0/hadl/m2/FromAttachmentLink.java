package io.github.cr3ahal0.hadl.m2;

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
        //We assume that the observable if the ProvidedPort port, just "notify" the role
        this.role.onReceive();
    }
}
