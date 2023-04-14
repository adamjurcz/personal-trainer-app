package com.adamjurcz.personaltrainerapp.dataproviders.jpa.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import com.adamjurcz.personaltrainerapp.dataproviders.entity.userprofiles.UserProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface JpaUserProfileRepository extends JpaRepository<UserProfileData, Long>{

    public Optional<UserProfileData> save(UserProfileData userProfileData);
    public Optional<UserProfileData> findById(Long id);
    public Boolean existsByUsername(String username);
    public Boolean existsByEmail(String email);
}
