package io.github.cr3ahal0.hadl.m2;

/**
 * Created by E130110Z on 16/11/15.
 */
public class ToAttachmentLink extends AttachmentLink {

    private RequiredPort port;

    private ToRole role;

    public void setFrom(ToRole role) {
        this.role = role;
    }

    public void setTo(RequiredPort port) {
        this.port = port;
    }

}
