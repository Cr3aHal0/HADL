package io.github.cr3ahal0.hadl.m1.global.clientserver.attachment;

import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.attachment.ToAttachmentLink;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by E130110Z on 23/11/15.
 */
public class RPCToServerAttachmentLink extends ToAttachmentLink {
    public RPCToServerAttachmentLink(ToRole role, RequiredPort port) {
        super(role, port);
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
