package io.github.cr3ahal0.hadl.m2;

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
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
