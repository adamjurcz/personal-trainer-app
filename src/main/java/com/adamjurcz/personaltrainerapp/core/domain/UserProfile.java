package com.adamjurcz.personaltrainerapp.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserProfile {
    private Identity id;
    private String username;
    private String email;
    private String password;

    public static UserProfile newInstance(String username, String email, String password){
        return new UserProfile(Identity.nothing(), username, email, password);
    }
}
