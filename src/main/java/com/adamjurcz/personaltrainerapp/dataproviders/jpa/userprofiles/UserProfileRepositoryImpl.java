package com.adamjurcz.personaltrainerapp.dataproviders.jpa.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import com.adamjurcz.personaltrainerapp.core.usecases.userprofiles.UserProfileRepository;
import com.adamjurcz.personaltrainerapp.dataproviders.entity.userprofiles.UserProfileData;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserProfileRepositoryImpl implements UserProfileRepository {
    private final JpaUserProfileRepository repository;

    public UserProfileRepositoryImpl(JpaUserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        UserProfileData result = repository.save(UserProfileData.mapToUserData(userProfile)).orElseThrow();
        return UserProfileData.mapToUser(result);
    }

    @Override
    public UserProfile getById(Identity id) {
        UserProfileData result = repository.findById(id.getValue()).orElseThrow();
        return UserProfileData.mapToUser(result);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
