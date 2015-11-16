package io.github.cr3ahal0.hadl.m2;

/**
 * Created by E130110Z on 16/11/15.
 */
public class FromAttachmentLink extends AttachmentLink {

    private ProvidedPort port;

    private FromRole role;

    public void setFrom(ProvidedPort port) {
        this.port = port;
    }

    public void setTo(FromRole role) {
        this.role = role;
    }

}
