package io.github.cr3ahal0.hadl.m1.global;

import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.clientserver.ClientServerConfiguration;
import io.github.cr3ahal0.hadl.m1.global.connector.ClientServerToServerConf;
import io.github.cr3ahal0.hadl.m1.global.serverconf.ServerConfiguration;
import io.github.cr3ahal0.hadl.m2.attachment.FromAttachmentLink;
import io.github.cr3ahal0.hadl.m2.attachment.ToAttachmentLink;
import io.github.cr3ahal0.hadl.m2.components.configuration.Configuration;
import io.github.cr3ahal0.hadl.m2.components.connector.Connector;
import io.github.cr3ahal0.hadl.m2.components.connector.SimpleGlue;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by E130110Z on 23/11/15.
 */
public class GlobalConfiguration extends Configuration {

    public GlobalConfiguration(String name) {
        super(name);

        try {
            //Client Server Configuration
            ClientServerConfiguration csc = new ClientServerConfiguration("ClientServerConfiguration");
            addComponent(csc);

            //Required ports
            RequiredPort crp = csc.getRequiredPort("ConfRequiredPort");

            //Provided ports
            ProvidedPort cpp = csc.getProvidedPort("ConfProvidedPort");

            //Connector
            Connector c = new ClientServerToServerConf("ClientServerToServerConfiguration");
            addComponent(c);

            //From role --> [
            FromRole fr1 = c.getFromRole("ClientServerFromRole");
            //From role ] <--
            FromRole fr2 = c.getFromRole("ServerConfFromRole");
            //To role ] -->
            ToRole tr1 = c.getToRole("ClientServerToRole");
            //To role <-- [
            ToRole tr2 = c.getToRole("ServerConfToRole");

            //Glue
            SimpleGlue g1 = new SimpleGlue(fr1, tr1);
            c.addSimpleGlue(g1);

            //Glue
            SimpleGlue g2 = new SimpleGlue(fr2, tr2);
            c.addSimpleGlue(g2);

            //ServerConfiguration
            ServerConfiguration sc = new ServerConfiguration("ServerConfiguration");
            addComponent(sc);

            //Required ports
            RequiredPort srp = sc.getRequiredPort("serverConfRequiredPort");

            //Provided ports
            ProvidedPort spp = sc.getProvidedPort("serverConfProvidedPort");

            //ClientServer -> Connector
            FromAttachmentLink fa1 = new FromAttachmentLink("FromClientServerToConnectorAttachment", cpp, fr1);

            addAttachmentLink(fa1);

            //Connector -> ServerConf
            ToAttachmentLink fa2 = new ToAttachmentLink("ConnectorToServerConfAttachment", tr1, srp);
            addAttachmentLink(fa2);

            //ServerConf -> Connector
            FromAttachmentLink fa3 = new FromAttachmentLink("ServerConfToConnectorAttachment", spp, fr2);

            addAttachmentLink(fa3);

            //Connector -> ClientServer
            ToAttachmentLink fa4 = new ToAttachmentLink("ConnectorToClientServerAttachment", tr2, crp);
            addAttachmentLink(fa4);
        } catch (NonExistingInterfaceException e) {
            System.out.println("One or more interfaces do not exist and are trying to be linked");
            e.printStackTrace();
        }
    }
}
