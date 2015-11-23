package io.github.cr3ahal0.hadl.m1.global.clientserver;

import io.github.cr3ahal0.hadl.m2.*;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientServerConfiguration extends Configuration {

    public ClientServerConfiguration() {

        //Client component
        ClientComponent client = new ClientComponent();
        addComponent(client);

        RequiredPort cr1 = new RequiredPort();
        RequiredPort cr2 = new RequiredPort();
        ProvidedPort cp1 = new ProvidedPort();
        ProvidedPort cp2 = new ProvidedPort();

        addProvidedPort(cp1);
        addProvidedPort(cp2);
        client.addRequiredPort(cr1);
        client.addRequiredPort(cr2);

        //Server
        ServerComponent server = new ServerComponent();
        addComponent(server);
        RequiredPort sr1 = new RequiredPort();
        RequiredPort sr2 = new RequiredPort();
        ProvidedPort sp1 = new ProvidedPort();
        ProvidedPort sp2 = new ProvidedPort();

        server.addRequiredPort(sr1);
        server.addRequiredPort(sr2);
        server.addProvidedPort(sp1);
        server.addProvidedPort(sp2);

        //Connector
        RPCConnector rpc = new RPCConnector();
        addComponent(rpc);
        FromRole f1 = new FromRole();
        FromRole f2 = new FromRole();
        ToRole t1 = new ToRole();
        ToRole t2 = new ToRole();

        rpc.addToRole(t1);
        rpc.addToRole(t2);
        rpc.addFromRole(f1);
        rpc.addFromRole(f2);

        // Glue ---> ... --->
        SimpleGlue g1 = new SimpleGlue();
        g1.setFrom(f1);
        g1.setTo(t1);

        rpc.addSimpleGlue(g1);

        //Glue <--- ... <---
        SimpleGlue g2 = new SimpleGlue();
        g1.setFrom(f2);
        g1.setTo(t2);

        rpc.addSimpleGlue(g2);

        //Attachment before ->
        ClientToRPCAttachmentLink a1 = new ClientToRPCAttachmentLink();
        addAttachmentLink(a1);
        a1.setFrom(cp1);
        a1.setTo(f1);

        //Attachment after ->
        RPCToServerAttachmentLink a2 = new RPCToServerAttachmentLink();
        addAttachmentLink(a2);
        a2.setFrom(t1);
        a2.setTo(sr1);

        //Attachment after <-
        ServerToRPCAttachmentLink a3 = new ServerToRPCAttachmentLink();
        addAttachmentLink(a3);
        a3.setFrom(sp1);
        a3.setTo(f2);

        //Attachment before <-
        RPCToClientAttachmentLink a4 = new RPCToClientAttachmentLink();
        addAttachmentLink(a4);
        a4.setFrom(t2);
        a4.setTo(cr1);
    }

}
