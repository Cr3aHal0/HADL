package io.github.cr3ahal0.hadl.m2.service;

import io.github.cr3ahal0.hadl.m2.INamedElement;
import io.github.cr3ahal0.hadl.m2.interfaces.Interface;

/**
 * Created by E130110Z on 16/11/15.
 */
public abstract class Service extends Interface implements INamedElement {

    public abstract Object onCalled();

}
