package com.adamjurcz.personaltrainerapp.core.usecases.exceptions;

public class NameAlreadyUsedException extends CoreException{
    public NameAlreadyUsedException(String message) {
        super(message);
    }
}
