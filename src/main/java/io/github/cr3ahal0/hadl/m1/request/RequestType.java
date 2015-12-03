package io.github.cr3ahal0.hadl.m1.request;

/**
 * Created by E130110Z on 03/12/15.
 */
public enum RequestType {
    DATABASE_AUTHENTICATION("DATABASE_AUTHENTICATION"),
    DATABASE_SQL_QUERY("DATABASE_SQL_QUERY");

    String name;

    RequestType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
