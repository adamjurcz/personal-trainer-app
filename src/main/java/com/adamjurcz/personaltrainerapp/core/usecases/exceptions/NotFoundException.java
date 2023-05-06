package com.adamjurcz.personaltrainerapp.core.usecases.exceptions;

public class NotFoundException extends CoreException{
    public NotFoundException(String message) {
        super(message);
    }
}
