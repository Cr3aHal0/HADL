package io.github.cr3ahal0.hadl.m1.global.clientserver.client;

import io.github.cr3ahal0.hadl.m2.attachment.FromAttachmentLink;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientToRPCAttachmentLink extends FromAttachmentLink {

    public ClientToRPCAttachmentLink(ProvidedPort port, FromRole role) {
        super(port, role);
    }

}
