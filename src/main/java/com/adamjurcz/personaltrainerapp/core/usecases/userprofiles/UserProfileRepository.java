package com.adamjurcz.personaltrainerapp.core.usecases.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;

import java.util.Optional;

public interface UserProfileRepository {
    UserProfile save(UserProfile userProfile);

    UserProfile getById(Identity id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
