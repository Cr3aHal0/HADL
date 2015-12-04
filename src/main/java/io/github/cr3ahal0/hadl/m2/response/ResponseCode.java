package io.github.cr3ahal0.hadl.m2.response;

/**
 * Created by Maxime on 04/12/2015.
 */
public enum ResponseCode {
    OK("200"),
    BAD_REQUEST("400"),
    UNAUTHORIZED("401"),
    FORBIDDEN("403");

    String code;

    ResponseCode(String code) {
        this.code = code;
    }
}
