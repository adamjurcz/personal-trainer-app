package com.adamjurcz.personaltrainerapp.core.usecases.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import com.adamjurcz.personaltrainerapp.core.usecases.UseCase;
import com.adamjurcz.personaltrainerapp.core.usecases.exceptions.NameAlreadyUsedException;
import lombok.Value;

public class AddUserProfileUseCase extends UseCase<AddUserProfileUseCase.Input, AddUserProfileUseCase.Output> {
    private UserProfileRepository userProfileRepository;

    public AddUserProfileUseCase(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public Output execute(Input input) {
        if(userProfileRepository.existsByEmail(input.email)){
            throw new NameAlreadyUsedException("Email already in use!");
        }
        if(userProfileRepository.existsByUsername(input.username)){
            throw new NameAlreadyUsedException("Username already in use!");
        }

        UserProfile userProfile = UserProfile.newInstance(input.getUsername(), input.getEmail(), input.getPassword());
        UserProfile savedUser = userProfileRepository.save(userProfile);
        return new Output(savedUser);
    }

    @Value
    public static class Input implements UseCase.Input{
        String username;
        String email;
        String password;
    }

    @Value
    public static class Output implements UseCase.Output{
        UserProfile userProfile;
    }
}
