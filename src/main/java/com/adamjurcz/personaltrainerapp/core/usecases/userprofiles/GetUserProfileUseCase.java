package com.adamjurcz.personaltrainerapp.core.usecases.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import com.adamjurcz.personaltrainerapp.core.usecases.UseCase;
import com.adamjurcz.personaltrainerapp.core.usecases.exceptions.NotFoundException;
import lombok.Value;

public class GetUserProfileUseCase extends UseCase<GetUserProfileUseCase.Input, GetUserProfileUseCase.Output> {

    private UserProfileRepository userProfileRepository;

    public GetUserProfileUseCase(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public Output execute(Input input) {
        UserProfile userProfile = userProfileRepository.getById(input.getId()).orElseThrow(()->
                new NotFoundException("ID:%d not exists"));
        return new Output(userProfile);
    }

    @Value
    public static class Input implements UseCase.Input{
        Identity id;
    }

    @Value
    public static class Output implements UseCase.Output{
        UserProfile userProfile;
    }

}
