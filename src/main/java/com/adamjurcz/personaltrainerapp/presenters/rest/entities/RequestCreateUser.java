package com.adamjurcz.personaltrainerapp.presenters.rest.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class RequestCreateUser {
    @NotBlank @Size(min = 6, max = 25) String username;
    @NotBlank @Size(max = 60) String email;
    @Size(min = 6, max = 60) String password;
}
