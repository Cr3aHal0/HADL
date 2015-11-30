package io.github.cr3ahal0.hadl.m1.global.clientserver;

import io.github.cr3ahal0.hadl.m2.FromAttachmentLink;
import io.github.cr3ahal0.hadl.m2.FromRole;
import io.github.cr3ahal0.hadl.m2.ProvidedPort;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientToRPCAttachmentLink extends FromAttachmentLink {

    public ClientToRPCAttachmentLink(ProvidedPort port, FromRole role) {
        super(port, role);
    }

}
