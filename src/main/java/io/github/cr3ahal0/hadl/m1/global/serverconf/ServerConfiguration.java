package io.github.cr3ahal0.hadl.m1.global.serverconf;

import io.github.cr3ahal0.hadl.m2.*;

/**
 * Created by E130110Z on 23/11/15.
 */
public class ServerConfiguration extends Configuration {

    public ServerConfiguration (String name) {
        super(name);

        // From ConnectionManager ...
        ConnectionManager connectionManager = new ConnectionManager("Connection Manager");

        ProvidedPort securityCheckProvidedPort = new ProvidedPort();
        RequiredPort securityCheckRequiredPort = new RequiredPort();
        connectionManager.addProvidedPort(securityCheckProvidedPort);
        connectionManager.addRequiredPort(securityCheckRequiredPort);

        // ClearanceRequest Connector
        Connector clearanceRequest = new Connector("Clearance Request");
        addComponent(clearanceRequest);

        //From role --> [
        FromRole clearanceRequestFromRole1 = new FromRole();
        //From role ] <--
        FromRole clearanceRequestFromRole2 = new FromRole();
        //To role ] -->
        ToRole clearanceRequestToRole1 = new ToRole();
        //To role <-- [
        ToRole clearanceRequestToRole2 = new ToRole();

        clearanceRequest.addFromRole(clearanceRequestFromRole1);
        clearanceRequest.addFromRole(clearanceRequestFromRole2);
        clearanceRequest.addToRole(clearanceRequestToRole1);
        clearanceRequest.addToRole(clearanceRequestToRole2);

        //ConnectionManager --> Attachment
        FromAttachmentLink clearanceRequestFromAttachment = new FromAttachmentLink(securityCheckProvidedPort, clearanceRequestFromRole1);
        addAttachmentLink(clearanceRequestFromAttachment);

        //ConnectionManager <-- Attachment
        ToAttachmentLink clearanceRequestToAttachment = new ToAttachmentLink(clearanceRequestToRole1, securityCheckRequiredPort);
        addAttachmentLink(clearanceRequestToAttachment);

        SimpleGlue clearanceRequestSimpleGlue1 = new SimpleGlue(clearanceRequestFromRole1, clearanceRequestToRole1);
        clearanceRequest.addSimpleGlue(clearanceRequestSimpleGlue1);

        SimpleGlue clearanceRequestSimpleGlue2 = new SimpleGlue(clearanceRequestFromRole2, clearanceRequestToRole2);
        clearanceRequest.addSimpleGlue(clearanceRequestSimpleGlue2);

        // ... To SecurityManager ...
        SecurityManager securityManager = new SecurityManager("Security Manager");
        addComponent(securityManager);

        RequiredPort securityAuthRequiredPort = new RequiredPort();
        ProvidedPort securityAuthProvidedPort = new ProvidedPort();
        securityManager.addProvidedPort(securityAuthProvidedPort);
        securityManager.addRequiredPort(securityAuthRequiredPort);

        //SecurityManager --> Attachment
        FromAttachmentLink securityManagerFromAttachment = new FromAttachmentLink(securityAuthProvidedPort, clearanceRequestFromRole2);
        addAttachmentLink(securityManagerFromAttachment);

        //Attachment <-- SecurityManager
        ToAttachmentLink securityManagerToAttachment = new ToAttachmentLink(clearanceRequestToRole2, securityAuthRequiredPort);
        addAttachmentLink(securityManagerToAttachment);

        // ---
        RequiredPort checkQueryRequiredPort = new RequiredPort();
        ProvidedPort checkQueryProvidedPort = new ProvidedPort();
        securityManager.addProvidedPort(checkQueryProvidedPort);
        securityManager.addRequiredPort(checkQueryRequiredPort);

        // SecurityQuery Connector
        Connector securityQuery = new Connector("Security Query");
        addComponent(securityQuery);

        //From role --> [
        FromRole securityQueryFromRole1 = new FromRole();
        //From role ] <--
        FromRole securityQueryFromRole2 = new FromRole();
        //To role ] -->
        ToRole securityQueryToRole1 = new ToRole();
        //To role <-- [
        ToRole securityQueryToRole2 = new ToRole();

        securityQuery.addFromRole(securityQueryFromRole1);
        securityQuery.addFromRole(securityQueryFromRole2);
        securityQuery.addToRole(securityQueryToRole1);
        securityQuery.addToRole(securityQueryToRole2);

        SimpleGlue securityQuerySimpleGlue1 = new SimpleGlue(clearanceRequestFromRole1, clearanceRequestToRole1);
        securityQuery.addSimpleGlue(securityQuerySimpleGlue1);

        SimpleGlue securityQuerySimpleGlue2 = new SimpleGlue(clearanceRequestFromRole2, clearanceRequestToRole2);
        securityQuery.addSimpleGlue(securityQuerySimpleGlue2);

        //SecurityManager --> Attachment
        FromAttachmentLink checkQueryFromAttachment = new FromAttachmentLink(checkQueryProvidedPort, securityQueryFromRole1);
        addAttachmentLink(checkQueryFromAttachment);

        //SecurityManager <-- Attachment
        ToAttachmentLink checkQueryToAttachment = new ToAttachmentLink(securityQueryToRole1, checkQueryRequiredPort);
        addAttachmentLink(checkQueryToAttachment);

        // ... To database
        Database database = new Database("Database");
        addComponent(database);

        ProvidedPort securityManagementProvidedPort = new ProvidedPort();
        RequiredPort securityManagementRequiredPort = new RequiredPort();
        database.addProvidedPort(securityManagementProvidedPort);
        database.addRequiredPort(securityManagementRequiredPort);

        ExecuteQueryService service = new ExecuteQueryService();
        database.addService(service);

        //Database --> Attachment
        FromAttachmentLink securityManagementFromAttachment = new FromAttachmentLink(securityManagementProvidedPort, securityQueryFromRole2);
        addAttachmentLink(securityManagementFromAttachment);

        //Database <-- Attachment
        ToAttachmentLink securityManagementToAttachment = new ToAttachmentLink(securityQueryToRole2, securityManagementRequiredPort);
        addAttachmentLink(securityManagementToAttachment);

        // SecurityQuery Connector
        Connector sqlQuery = new Connector("SQL Query");
        addComponent(sqlQuery);

        //From role --> [
        FromRole sqlQueryFromRole1 = new FromRole();
        //From role ] <--
        FromRole sqlQueryFromRole2 = new FromRole();
        //To role ] -->
        ToRole sqlQueryToRole1 = new ToRole();
        //To role <-- [
        ToRole sqlQueryToRole2 = new ToRole();

        sqlQuery.addFromRole(sqlQueryFromRole1);
        sqlQuery.addFromRole(sqlQueryFromRole2);
        sqlQuery.addToRole(sqlQueryToRole1);
        sqlQuery.addToRole(sqlQueryToRole2);

        SimpleGlue sqlQuerySimpleGlue1 = new SimpleGlue(sqlQueryFromRole1, sqlQueryToRole1);
        sqlQuery.addSimpleGlue(sqlQuerySimpleGlue1);

        SimpleGlue sqlQuerySimpleGlue2 = new SimpleGlue(sqlQueryFromRole2, sqlQueryToRole2);
        sqlQuery.addSimpleGlue(sqlQuerySimpleGlue2);

        ProvidedPort queryProvidedPort = new ProvidedPort();
        RequiredPort queryRequiredPort = new RequiredPort();
        database.addProvidedPort(queryProvidedPort);
        database.addRequiredPort(queryRequiredPort);

        //Database --> Attachment
        FromAttachmentLink queryFromAttachment = new FromAttachmentLink(queryProvidedPort, sqlQueryFromRole1);
        addAttachmentLink(queryFromAttachment);

        //Database <-- Attachment
        ToAttachmentLink queryToAttachment = new ToAttachmentLink(sqlQueryToRole1, queryRequiredPort);
        addAttachmentLink(queryToAttachment);

        //back to ConnectionManager
        ProvidedPort dbQueryProvidedPort = new ProvidedPort();
        RequiredPort dbQueryRequiredPort = new RequiredPort();
        connectionManager.addProvidedPort(dbQueryProvidedPort);
        connectionManager.addRequiredPort(dbQueryRequiredPort);

        //ConnectionManager --> Attachment
        FromAttachmentLink dbQueryFromAttachment = new FromAttachmentLink(dbQueryProvidedPort, sqlQueryFromRole2);
        addAttachmentLink(dbQueryFromAttachment);

        //ConnectionManager <-- Attachment
        ToAttachmentLink dbQueryToAttachment = new ToAttachmentLink(sqlQueryToRole2, dbQueryRequiredPort);
        addAttachmentLink(dbQueryToAttachment);

        //ANNNNNND The final part
        ProvidedPort externalSocketProvidedPort = new ProvidedPort();
        RequiredPort externalSocketRequiredPort = new RequiredPort();
        connectionManager.addProvidedPort(externalSocketProvidedPort);
        connectionManager.addRequiredPort(externalSocketRequiredPort);

        ProvidedPort serverConfProvidedPort = new ProvidedPort();
        RequiredPort serverConfRequiredPort = new RequiredPort();
        addProvidedPort(serverConfProvidedPort);
        addRequiredPort(serverConfRequiredPort);

        ProvidedBindingLink providedBindingLink = new ProvidedBindingLink(serverConfProvidedPort, externalSocketProvidedPort);
        addProvidedBindingLink(providedBindingLink);

        RequiredBindingLink requiredBindingLink = new RequiredBindingLink(serverConfRequiredPort, externalSocketRequiredPort);
        addRequiredBindingLink(requiredBindingLink);
    }
}
