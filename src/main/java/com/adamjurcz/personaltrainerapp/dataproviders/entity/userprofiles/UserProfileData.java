package com.adamjurcz.personaltrainerapp.dataproviders.entity.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "user_profile")
@Entity
public class UserProfileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public static UserProfileData mapToUserData(UserProfile userProfile){
        return new UserProfileData(userProfile.getId().getValue(), userProfile.getUsername(), userProfile.getEmail(), userProfile.getPassword());
    }

    public static UserProfile mapToUser(UserProfileData userProfileData){
        return new UserProfile(new Identity(userProfileData.getId()), userProfileData.getUsername(), userProfileData.getEmail(), userProfileData.getPassword());
    }
}
