package io.github.cr3ahal0.hadl.m1.global.serverconf;

import com.sun.org.apache.xpath.internal.SourceTree;
import io.github.cr3ahal0.hadl.m1.exception.NonExistingInterfaceException;
import io.github.cr3ahal0.hadl.m1.global.serverconf.clearancerequest.ClearanceRequest;
import io.github.cr3ahal0.hadl.m1.global.serverconf.configuration.ServerConfProvidedPort;
import io.github.cr3ahal0.hadl.m1.global.serverconf.configuration.ServerConfRequiredPort;
import io.github.cr3ahal0.hadl.m1.global.serverconf.connectionmanager.*;
import io.github.cr3ahal0.hadl.m1.global.serverconf.database.Database;
import io.github.cr3ahal0.hadl.m1.global.serverconf.securityQuery.SecurityQuery;
import io.github.cr3ahal0.hadl.m1.global.serverconf.securitymanager.*;
import io.github.cr3ahal0.hadl.m1.global.serverconf.securitymanager.SecurityManager;
import io.github.cr3ahal0.hadl.m1.global.serverconf.sqlquery.SqlQuery;
import io.github.cr3ahal0.hadl.m2.attachment.FromAttachmentLink;
import io.github.cr3ahal0.hadl.m2.attachment.ToAttachmentLink;
import io.github.cr3ahal0.hadl.m2.binding.ProvidedBindingLink;
import io.github.cr3ahal0.hadl.m2.binding.RequiredBindingLink;
import io.github.cr3ahal0.hadl.m2.components.configuration.Configuration;
import io.github.cr3ahal0.hadl.m2.components.connector.Connector;
import io.github.cr3ahal0.hadl.m2.components.connector.SimpleGlue;
import io.github.cr3ahal0.hadl.m2.interfaces.port.ProvidedPort;
import io.github.cr3ahal0.hadl.m2.interfaces.port.RequiredPort;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;
import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerConfiguration extends Configuration {

    public ServerConfiguration (String name) {
        super(name);

        try {
            // From ConnectionManager ...
            ConnectionManager connectionManager = new ConnectionManager("Connection Manager");

            ProvidedPort securityCheckProvidedPort = connectionManager.getProvidedPort("securityCheckProvidedPort");
            RequiredPort securityCheckRequiredPort = connectionManager.getRequiredPort("securityCheckRequiredPort");

            // ClearanceRequest Connector
            ClearanceRequest clearanceRequest = new ClearanceRequest("Clearance Request");
            addComponent(clearanceRequest);

            //From role --> [
            FromRole clearanceRequestFromRole1 = clearanceRequest.getFromRole("clearanceRequestFromRole1");
            //From role ] <--
            FromRole clearanceRequestFromRole2 = clearanceRequest.getFromRole("clearanceRequestFromRole2");
            //To role ] -->
            ToRole clearanceRequestToRole1 = clearanceRequest.getToRole("clearanceRequestToRole1");
            //To role <-- [
            ToRole clearanceRequestToRole2 = clearanceRequest.getToRole("clearanceRequestToRole2");


            //ConnectionManager --> Attachment
            FromAttachmentLink clearanceRequestFromAttachment = new FromAttachmentLink("clearanceRequestFromAttachment", securityCheckProvidedPort, clearanceRequestFromRole1);
            addAttachmentLink(clearanceRequestFromAttachment);

            //ConnectionManager <-- Attachment
            ToAttachmentLink clearanceRequestToAttachment = new ToAttachmentLink("clearanceRequestToAttachment", clearanceRequestToRole1, securityCheckRequiredPort);
            addAttachmentLink(clearanceRequestToAttachment);

            SimpleGlue clearanceRequestSimpleGlue1 = new SimpleGlue(clearanceRequestFromRole1, clearanceRequestToRole2);
            clearanceRequest.addSimpleGlue(clearanceRequestSimpleGlue1);

            SimpleGlue clearanceRequestSimpleGlue2 = new SimpleGlue(clearanceRequestFromRole2, clearanceRequestToRole1);
            clearanceRequest.addSimpleGlue(clearanceRequestSimpleGlue2);

            // ... To SecurityManager ...
            SecurityManager securityManager = new SecurityManager("Security Manager");
            addComponent(securityManager);

            RequiredPort securityAuthRequiredPort = securityManager.getRequiredPort("securityAuthRequiredPort");
            ProvidedPort securityAuthProvidedPort = securityManager.getProvidedPort("securityAuthProvidedPort");

            //SecurityManager --> Attachment
            FromAttachmentLink securityManagerFromAttachment = new FromAttachmentLink("securityManagerFromAttachment", securityAuthProvidedPort, clearanceRequestFromRole2);
            addAttachmentLink(securityManagerFromAttachment);

            //Attachment <-- SecurityManager
            ToAttachmentLink securityManagerToAttachment = new ToAttachmentLink("securityManagerToAttachment", clearanceRequestToRole2, securityAuthRequiredPort);
            addAttachmentLink(securityManagerToAttachment);


            // ---
            RequiredPort checkQueryRequiredPort = new CheckQueryRequiredPort("checkQueryRequiredPort");
            ProvidedPort checkQueryProvidedPort = new CheckQueryProvidedPort("checkQueryProvidedPort");

            // SecurityQuery Connector
            SecurityQuery securityQuery = new SecurityQuery("Security Query");
            addComponent(securityQuery);

            //From role --> [
            FromRole securityQueryFromRole1 = securityQuery.getFromRole("securityQueryFromRole1");
            //From role ] <--
            FromRole securityQueryFromRole2 = securityQuery.getFromRole("securityQueryFromRole2");
            //To role ] -->
            ToRole securityQueryToRole1 = securityQuery.getToRole("securityQueryToRole1");
            //To role <-- [
            ToRole securityQueryToRole2 = securityQuery.getToRole("securityQueryToRole2");

            SimpleGlue securityQuerySimpleGlue1 = new SimpleGlue(securityQueryFromRole1, securityQueryToRole1);
            securityQuery.addSimpleGlue(securityQuerySimpleGlue1);

            SimpleGlue securityQuerySimpleGlue2 = new SimpleGlue(securityQueryFromRole2, securityQueryToRole2);
            securityQuery.addSimpleGlue(securityQuerySimpleGlue2);

            //SecurityManager --> Attachment
            FromAttachmentLink checkQueryFromAttachment = new FromAttachmentLink("checkQueryFromAttachment", checkQueryProvidedPort, securityQueryFromRole1);
            addAttachmentLink(checkQueryFromAttachment);

            //SecurityManager <-- Attachment
            ToAttachmentLink checkQueryToAttachment = new ToAttachmentLink("checkQueryToAttachment", securityQueryToRole1, checkQueryRequiredPort);
            addAttachmentLink(checkQueryToAttachment);

            // ... To database
            Database database = new Database("Database");
            addComponent(database);

            ProvidedPort securityManagementProvidedPort = database.getProvidedPort("securityManagementProvidedPort");
            RequiredPort securityManagementRequiredPort = database.getRequiredPort("securityManagementRequiredPort");

            //Database --> Attachment
            FromAttachmentLink securityManagementFromAttachment = new FromAttachmentLink("securityManagementFromAttachment", securityManagementProvidedPort, securityQueryFromRole2);
            addAttachmentLink(securityManagementFromAttachment);

            //Database <-- Attachment
            ToAttachmentLink securityManagementToAttachment = new ToAttachmentLink("securityManagementToAttachment", securityQueryToRole2, securityManagementRequiredPort);
            addAttachmentLink(securityManagementToAttachment);

            // SecurityQuery Connector
            SqlQuery sqlQuery = new SqlQuery("SQL Query");
            addComponent(sqlQuery);

            //From role --> [
            FromRole sqlQueryFromRole1 = sqlQuery.getFromRole("sqlQueryFromRole1");
            //From role ] <--
            FromRole sqlQueryFromRole2 = sqlQuery.getFromRole("sqlQueryFromRole2");
            //To role ] -->
            ToRole sqlQueryToRole1 = sqlQuery.getToRole("sqlQueryToRole1");
            //To role <-- [
            ToRole sqlQueryToRole2 = sqlQuery.getToRole("sqlQueryToRole2");


            SimpleGlue sqlQuerySimpleGlue1 = new SimpleGlue(sqlQueryFromRole1, sqlQueryToRole2);
            sqlQuery.addSimpleGlue(sqlQuerySimpleGlue1);

            SimpleGlue sqlQuerySimpleGlue2 = new SimpleGlue(sqlQueryFromRole2, sqlQueryToRole1);
            sqlQuery.addSimpleGlue(sqlQuerySimpleGlue2);

            ProvidedPort queryProvidedPort = database.getProvidedPort("queryProvidedPort");
            RequiredPort queryRequiredPort = database.getRequiredPort("queryRequiredPort");

            //Database --> Attachment
            FromAttachmentLink queryFromAttachment = new FromAttachmentLink("queryFromAttachment", queryProvidedPort, sqlQueryFromRole1);
            addAttachmentLink(queryFromAttachment);

            //Database <-- Attachment
            ToAttachmentLink queryToAttachment = new ToAttachmentLink("queryToAttachment", sqlQueryToRole1, queryRequiredPort);
            addAttachmentLink(queryToAttachment);

            //back to ConnectionManager
            ProvidedPort dbQueryProvidedPort = connectionManager.getProvidedPort("dbQueryProvidedPort");
            RequiredPort dbQueryRequiredPort = connectionManager.getRequiredPort("dbQueryRequiredPort");

            //ConnectionManager --> Attachment
            FromAttachmentLink dbQueryFromAttachment = new FromAttachmentLink("dbQueryFromAttachment", dbQueryProvidedPort, sqlQueryFromRole2);
            addAttachmentLink(dbQueryFromAttachment);

            //ConnectionManager <-- Attachment
            ToAttachmentLink dbQueryToAttachment = new ToAttachmentLink("dbQueryToAttachment", sqlQueryToRole2, dbQueryRequiredPort);
            addAttachmentLink(dbQueryToAttachment);

            //ANNNNNND The final part
            ProvidedPort externalSocketProvidedPort = connectionManager.getProvidedPort("externalSocketProvidedPort");
            RequiredPort externalSocketRequiredPort = connectionManager.getRequiredPort("externalSocketRequiredPort");

            ProvidedPort serverConfProvidedPort = new ServerConfProvidedPort("serverConfProvidedPort");
            RequiredPort serverConfRequiredPort = new ServerConfRequiredPort("serverConfRequiredPort");
            addProvidedPort(serverConfProvidedPort);
            addRequiredPort(serverConfRequiredPort);

            ProvidedBindingLink providedBindingLink = new ProvidedBindingLink(serverConfProvidedPort, externalSocketProvidedPort);
            addProvidedBindingLink(providedBindingLink);

            RequiredBindingLink requiredBindingLink = new RequiredBindingLink(serverConfRequiredPort, externalSocketRequiredPort);
            addRequiredBindingLink(requiredBindingLink);
        } catch (NonExistingInterfaceException e) {
            System.out.println("One or more interfaces do not exist and are trying to be added");
            e.printStackTrace();
        }
    }

}
