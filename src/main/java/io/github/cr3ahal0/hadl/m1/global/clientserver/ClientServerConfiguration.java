package io.github.cr3ahal0.hadl.m1.global.clientserver;

import io.github.cr3ahal0.hadl.m2.*;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientServerConfiguration extends Configuration {

    public ClientServerConfiguration() {

        //Conf provider port  ] -->
        ProvidedPort pp = new ProvidedPort();
        this.addProvidedPort(pp);

        //Conf required port ] <--
        RequiredPort rp = new RequiredPort();
        this.addRequiredPort(rp);

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
        SimpleGlue g1 = new SimpleGlue(f1, t1);
        rpc.addSimpleGlue(g1);

        //Glue <--- ... <---
        SimpleGlue g2 = new SimpleGlue(f2, t2);
        rpc.addSimpleGlue(g2);

        //Attachment before ->
        ClientToRPCAttachmentLink a1 = new ClientToRPCAttachmentLink(cp1, f1);
        addAttachmentLink(a1);

        //Attachment after ->
        RPCToServerAttachmentLink a2 = new RPCToServerAttachmentLink(t1, sr1);
        addAttachmentLink(a2);

        //Attachment after <-
        ServerToRPCAttachmentLink a3 = new ServerToRPCAttachmentLink(sp1, f2);
        addAttachmentLink(a3);

        //Attachment before <-
        RPCToClientAttachmentLink a4 = new RPCToClientAttachmentLink(t2, cr1);
        addAttachmentLink(a4);

        //Provided Binding link ] -->
        ProvidedBindingLink pbl = new ProvidedBindingLink(pp, sp2);
        addProvidedBindingLink(pbl);

        //Required Binding Link ] <--
        RequiredBindingLink rbl = new RequiredBindingLink(rp, sr2);
        addRequiredBindingLink(rbl);
    }

}
