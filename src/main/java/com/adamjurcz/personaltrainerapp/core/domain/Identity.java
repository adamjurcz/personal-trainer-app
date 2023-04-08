package com.adamjurcz.personaltrainerapp.core.domain;

import lombok.Value;

@Value
public class Identity {
    private final Long value;

    public static Identity nothing(){
        return new Identity(Long.MIN_VALUE);
    }
}
