package io.github.cr3ahal0.hadl.m1.global.serverconf;

import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.service.Service;

/**
 * Created by E130110Z on 30/11/15.
 */
public class ExecuteQueryService extends Service {

    public ExecuteQueryService(String name) {
        super(name);
    }

    @Override
    public Object onCalled() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
