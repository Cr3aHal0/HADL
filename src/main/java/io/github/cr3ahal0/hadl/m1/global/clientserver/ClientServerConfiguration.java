package io.github.cr3ahal0.hadl.m1.global.clientserver;

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

        //Conf provider port  ] -->
        ConfProvidedPort pp = new ConfProvidedPort();
        this.addProvidedPort(pp);

        //Conf required port ] <--
        ConfRequiredPort rp = new ConfRequiredPort();
        this.addRequiredPort(rp);

        //Client component
        ClientComponent client = new ClientComponent("Client");
        addComponent(client);

        RequiredPort[] clientsRequiredPort = (RequiredPort[])client.getRequiredPorts().toArray();
        ProvidedPort[] clientsProvidedPort = (ProvidedPort[])client.getProvidedPorts().toArray();
        RequiredPort cr1 = clientsRequiredPort[0];
        RequiredPort cr2 = clientsRequiredPort[1];
        ProvidedPort cp1 = clientsProvidedPort[0];
        ProvidedPort cp2 = clientsProvidedPort[1];

        //Server
        ServerComponent server = new ServerComponent("Server");
        addComponent(server);

        RequiredPort[] serverRequiredPort = (RequiredPort[])server.getRequiredPorts().toArray();
        ProvidedPort[] serverProvidedPort = (ProvidedPort[])server.getProvidedPorts().toArray();

        RequiredPort sr1 = serverRequiredPort[0];
        RequiredPort sr2 = serverRequiredPort[1];
        ProvidedPort sp1 = serverProvidedPort[0];
        ProvidedPort sp2 = serverProvidedPort[1];

        //Connector
        RPCConnector rpc = new RPCConnector("RPC");
        addComponent(rpc);

        FromRole[] rpcFromRoles = (FromRole[])rpc.getFromRoles().toArray();
        ToRole[] rpcToRoles = (ToRole[])rpc.getToRoles().toArray();

        FromRole f1 = rpcFromRoles[0];
        FromRole f2 = rpcFromRoles[1];
        ToRole t1 = rpcToRoles[0];
        ToRole t2 = rpcToRoles[1];

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
