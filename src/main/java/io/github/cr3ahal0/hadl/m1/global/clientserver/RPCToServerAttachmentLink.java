package io.github.cr3ahal0.hadl.m1.global.clientserver;

import io.github.cr3ahal0.hadl.m2.RequiredPort;
import io.github.cr3ahal0.hadl.m2.ToAttachmentLink;
import io.github.cr3ahal0.hadl.m2.ToRole;

/**
 * Created by E130110Z on 23/11/15.
 */
public class RPCToServerAttachmentLink extends ToAttachmentLink {
    public RPCToServerAttachmentLink(ToRole role, RequiredPort port) {
        super(role, port);
    }
}
