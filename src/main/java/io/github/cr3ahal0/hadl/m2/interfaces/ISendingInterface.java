package io.github.cr3ahal0.hadl.m2.interfaces;

import io.github.cr3ahal0.hadl.m2.request.Request;
import io.github.cr3ahal0.hadl.m2.response.Response;

/**
 * Created by E130110Z on 02/12/15.
 */
public interface ISendingInterface {

    public void onSend(Request request);

    public void onSend(Response response);

}
