package com.adamjurcz.personaltrainerapp.dataproviders.jpa.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import com.adamjurcz.personaltrainerapp.core.usecases.exceptions.TrainerApiException;
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
        UserProfileData result = repository.save(UserProfileData.mapToUserData(userProfile));
        return UserProfileData.mapToUser(result);
    }

    @Override
    public Optional<UserProfile> getById(Identity id) {
        Optional<UserProfileData> userProfile = repository.findById(id.getValue());
        return userProfile.map(UserProfileData::mapToUser);
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
