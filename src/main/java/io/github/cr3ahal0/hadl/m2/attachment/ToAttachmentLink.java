package io.github.cr3ahal0.hadl.m2.attachment;

import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

import java.util.Observable;

/**
 * Created by E130110Z on 16/11/15.
 */
public class ToAttachmentLink extends AttachmentLink {

    private RequiredPort port;

    private ToRole role;

    public ToAttachmentLink(ToRole role, RequiredPort port) {
        this.role = role;
        this.port = port;

        this.role.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.port.onReceive((Request)arg);
    }
}
