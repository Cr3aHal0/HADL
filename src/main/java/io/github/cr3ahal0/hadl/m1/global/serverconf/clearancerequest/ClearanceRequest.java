package io.github.cr3ahal0.hadl.m1.global.serverconf.clearancerequest;

import io.github.cr3ahal0.hadl.m2.components.connector.Connector;
import io.github.cr3ahal0.hadl.m2.interfaces.role.FromRole;
import io.github.cr3ahal0.hadl.m2.interfaces.role.ToRole;

/**
 * Created by E130110Z on 02/12/15.
 */
public class ClearanceRequest extends Connector {
    /**
     * constructor
     *
     * @param name
     */
    public ClearanceRequest(String name) {
        super(name);

        //From role --> [
        ClearanceRequestFromRole clearanceRequestFromRole1 = new ClearanceRequestFromRole("clearanceRequestFromRole1");
        //From role ] <--
        ClearanceRequestFromRole clearanceRequestFromRole2 = new ClearanceRequestFromRole("clearanceRequestFromRole2");
        //To role ] -->
        ClearanceRequestToRole clearanceRequestToRole1 = new ClearanceRequestToRole("clearanceRequestToRole1");
        //To role <-- [
        ClearanceRequestToRole clearanceRequestToRole2 = new ClearanceRequestToRole("clearanceRequestToRole2");

        addFromRole(clearanceRequestFromRole1);
        addFromRole(clearanceRequestFromRole2);
        addToRole(clearanceRequestToRole1);
        addToRole(clearanceRequestToRole2);
    }
}
