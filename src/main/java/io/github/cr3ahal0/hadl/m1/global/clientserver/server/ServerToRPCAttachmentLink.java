package io.github.cr3ahal0.hadl.m1.global.clientserver.server;

import io.github.cr3ahal0.hadl.m2.attachment.FromAttachmentLink;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerToRPCAttachmentLink extends FromAttachmentLink {
    public ServerToRPCAttachmentLink(ProvidedPort port, FromRole role) {
        super(port, role);
    }

    String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
