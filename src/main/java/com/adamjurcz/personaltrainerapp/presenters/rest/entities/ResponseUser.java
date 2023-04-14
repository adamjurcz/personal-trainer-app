package com.adamjurcz.personaltrainerapp.presenters.rest.entities;

import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import lombok.Value;

@Value
public class ResponseUser {
    Long id;
    String username;
    String email;
    public static ResponseUser mapToResponse(UserProfile userProfile){
        return new ResponseUser(userProfile.getId().getValue(), userProfile.getUsername(), userProfile.getEmail());
    }
}
