package io.github.cr3ahal0.hadl.m2.response;

import io.github.cr3ahal0.hadl.m2.request.Request;

/**
 * Created by Maxime on 04/12/2015.
 */
public class Response {

    private Request request;

    private ResponseCode code;

    private String data;

    public Response (Request request) {
        this.request = request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public ResponseCode getCode() {
        return this.code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

}
