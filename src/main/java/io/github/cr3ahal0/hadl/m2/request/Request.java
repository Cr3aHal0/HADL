package io.github.cr3ahal0.hadl.m2.request;

import io.github.cr3ahal0.hadl.m2.components.component.Component;
import io.github.cr3ahal0.hadl.m2.interfaces.Interface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E130110Z on 30/11/15.
 */
public class Request {

    RequestKind kind;

    String service;

    String data;

    private Component origin;

    private Component target;

    private List<Interface> steps;

    boolean definitive;

    public Request(Component origin, Component target, String service) {
        this(origin, target, service, RequestKind.SYNCHRONEOUS);
    }

    public Request(Component origin, Component target, String service, RequestKind kind) {
        this.origin = origin;
        this.target = target;
        this.service = service;
        this.kind = kind;

        //We assume that, at the very beginning, the origin does not know its exact target
        this.definitive = false;

        steps = new ArrayList<Interface>();
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addStep(Interface inter) {
        steps.add(inter);
    }

    public boolean isSynchroneous() {
        return (kind.equals(RequestKind.SYNCHRONEOUS));
    }

    public boolean isAsynchroneous() {
        return (kind.equals(RequestKind.ASYNCHRONEOUS));
    }

    public Component getOrigin() {
        return this.origin;
    }

    public Component getTarget() {
        return this.target;
    }

    public void setTarget(Component target) {
        this.target = target;
    }
}
