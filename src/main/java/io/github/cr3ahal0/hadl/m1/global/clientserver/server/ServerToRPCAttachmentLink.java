package io.github.cr3ahal0.hadl.m1.global.clientserver.server;

import io.github.cr3ahal0.hadl.m2.attachment.FromAttachmentLink;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerToRPCAttachmentLink extends FromAttachmentLink {
    public ServerToRPCAttachmentLink(String name, ProvidedPort port, FromRole role) {
        super(name, port, role);
    }

    @Override
    public String getName() {
        return name;
    }
}
