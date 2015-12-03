package io.github.cr3ahal0.hadl.m1.global.clientserver;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.clientserver.RPC.RPCConnector;
import io.github.cr3ahal0.hadl.m1.global.clientserver.attachment.RPCToClientAttachmentLink;
import io.github.cr3ahal0.hadl.m1.global.clientserver.attachment.RPCToServerAttachmentLink;
import io.github.cr3ahal0.hadl.m1.global.clientserver.client.ClientComponent;
import io.github.cr3ahal0.hadl.m1.global.clientserver.client.ClientToRPCAttachmentLink;
import io.github.cr3ahal0.hadl.m1.global.clientserver.configuration.ConfProvidedPort;
import io.github.cr3ahal0.hadl.m1.global.clientserver.configuration.ConfRequiredPort;
import io.github.cr3ahal0.hadl.m1.global.clientserver.server.ServerComponent;
import io.github.cr3ahal0.hadl.m1.global.clientserver.server.ServerToRPCAttachmentLink;
import io.github.cr3ahal0.hadl.m2.binding.ProvidedBindingLink;
import io.github.cr3ahal0.hadl.m2.binding.RequiredBindingLink;
import io.github.cr3ahal0.hadl.m2.components.configuration.Configuration;
import io.github.cr3ahal0.hadl.m2.components.connector.SimpleGlue;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ClientServerConfiguration extends Configuration {

    public ClientServerConfiguration(String name) {
        super(name);

        try {
            //Conf provider port  ] -->
            ConfProvidedPort pp = new ConfProvidedPort("ConfProvidedPort");
            this.addProvidedPort(pp);

            //Conf required port ] <--
            ConfRequiredPort rp = new ConfRequiredPort("ConfRequiredPort");
            this.addRequiredPort(rp);

            //Client component
            ClientComponent client = new ClientComponent("Client");
            addComponent(client);

            RequiredPort cr1 = client.getRequiredPort("cr1");
            RequiredPort cr2 = client.getRequiredPort("cr2");
            ProvidedPort cp1 = client.getProvidedPort("cp1");
            ProvidedPort cp2 = client.getProvidedPort("cp2");

            //Server
            ServerComponent server = new ServerComponent("Server");
            addComponent(server);

            RequiredPort sr1 = server.getRequiredPort("sr1");
            RequiredPort sr2 = server.getRequiredPort("sr2");
            ProvidedPort sp1 = server.getProvidedPort("sp1");
            ProvidedPort sp2 = server.getProvidedPort("sp2");

            //Connector
            RPCConnector rpc = new RPCConnector("RPC");
            addComponent(rpc);

            FromRole f1 = rpc.getFromRole("f1");
            FromRole f2 = rpc.getFromRole("f2");
            ToRole t1 = rpc.getToRole("t1");
            ToRole t2 = rpc.getToRole("t2");

            // Glue ---> ... --->
            SimpleGlue g1 = new SimpleGlue(f1, t1);
            rpc.addSimpleGlue(g1);

            //Glue <--- ... <---
            SimpleGlue g2 = new SimpleGlue(f2, t2);
            rpc.addSimpleGlue(g2);

            //Attachment before ->
            ClientToRPCAttachmentLink a1 = new ClientToRPCAttachmentLink("ClientToRPCAttachmentLink", cp1, f1);
            addAttachmentLink(a1);

            //Attachment after ->
            RPCToServerAttachmentLink a2 = new RPCToServerAttachmentLink("RPCToServerAttachmentLink", t1, sr1);
            addAttachmentLink(a2);

            //Attachment after <-
            ServerToRPCAttachmentLink a3 = new ServerToRPCAttachmentLink("ServerToRPCAttachmentLink", sp1, f2);
            addAttachmentLink(a3);

            //Attachment before <-
            RPCToClientAttachmentLink a4 = new RPCToClientAttachmentLink("RPCToClientAttachmentLink", t2, cr1);
            addAttachmentLink(a4);

            //Provided Binding link ] -->
            ProvidedBindingLink pbl = new ProvidedBindingLink(pp, sp2);
            addProvidedBindingLink(pbl);

            //Required Binding Link ] <--
            RequiredBindingLink rbl = new RequiredBindingLink(rp, sr2);
            addRequiredBindingLink(rbl);
        } catch (NonExistingInterfaceException e) {
            System.out.println("One or more interfaces do not exist");
            e.printStackTrace();
        }
    }

}
