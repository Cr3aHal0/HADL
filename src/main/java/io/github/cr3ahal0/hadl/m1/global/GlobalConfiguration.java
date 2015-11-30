package io.github.cr3ahal0.hadl.m1.global;

import io.github.cr3ahal0.hadl.m1.global.clientserver.ClientServerConfiguration;
import io.github.cr3ahal0.hadl.m1.global.serverconf.ServerConfiguration;
import io.github.cr3ahal0.hadl.m2.*;

import java.util.Set;

/**
 * Created by E130110Z on 23/11/15.
 */
public class GlobalConfiguration extends Configuration {

    public GlobalConfiguration(String name) {
        super(name);

        //Client Server Configuration
        ClientServerConfiguration csc = new ClientServerConfiguration("Client Server Configuration");
        addComponent(csc);

        //Required ports
        RequiredPort[] crp = (RequiredPort[])csc.getRequiredPorts().toArray();

        //Provided ports
        ProvidedPort[] cpp = (ProvidedPort[])csc.getProvidedPorts().toArray();

        //Connector
        Connector c = new Connector("Client-Server to Server Configuration");
        addComponent(c);

        //From role --> [
        FromRole fr1 = new FromRole();
        //From role ] <--
        FromRole fr2 = new FromRole();
        //To role ] -->
        ToRole tr1 = new ToRole();
        //To role <-- [
        ToRole tr2 = new ToRole();

        c.addFromRole(fr1);
        c.addFromRole(fr2);
        c.addToRole(tr1);
        c.addToRole(tr2);

        //Glue
        SimpleGlue g1 = new SimpleGlue(fr1, tr1);

        c.addSimpleGlue(g1);

        //Glue
        SimpleGlue g2 = new SimpleGlue(fr2, tr2);
        c.addSimpleGlue(g2);

        //ServerConfiguration
        ServerConfiguration sc = new ServerConfiguration("Server Configuration");
        addComponent(sc);

        //Required ports
        RequiredPort[] srp = (RequiredPort[])sc.getRequiredPorts().toArray();

        //Provided ports
        ProvidedPort[] spp = (ProvidedPort[])sc.getProvidedPorts().toArray();

        //ClientServer -> Connector
        FromAttachmentLink fa1 = new FromAttachmentLink(cpp[0], fr1);

        addAttachmentLink(fa1);

        //Connector -> ServerConf
        ToAttachmentLink fa2 = new ToAttachmentLink(tr1, srp[0]);
        addAttachmentLink(fa2);

        //ServerConf -> Connector
        FromAttachmentLink fa3 = new FromAttachmentLink(spp[0], fr2);

        addAttachmentLink(fa3);

        //Connector -> ClientServer
        ToAttachmentLink fa4 = new ToAttachmentLink(tr2, crp[0]);
        addAttachmentLink(fa4);
    }
}
