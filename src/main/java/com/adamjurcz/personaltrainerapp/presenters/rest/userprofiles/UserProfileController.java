package com.adamjurcz.personaltrainerapp.presenters.rest.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.UserProfile;
import com.adamjurcz.personaltrainerapp.core.usecases.userprofiles.AddUserProfileUseCase;
import com.adamjurcz.personaltrainerapp.presenters.rest.entities.RequestCreateUser;
import com.adamjurcz.personaltrainerapp.presenters.rest.entities.ResponseUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserProfileController.endpoint)
public class UserProfileController {
    public static final String endpoint = "/api/v1/users";

    private final AddUserProfileUseCase addUserProfileUseCase;

    public UserProfileController(AddUserProfileUseCase addUserProfileUseCase) {
        this.addUserProfileUseCase = addUserProfileUseCase;
    }

    @PostMapping
    ResponseUser addUser(@Valid @RequestBody RequestCreateUser requestCreateUser){
         AddUserProfileUseCase.Input input= new AddUserProfileUseCase.Input(requestCreateUser.getUsername(),
                 requestCreateUser.getEmail(), requestCreateUser.getPassword());
         return ResponseUser.mapToResponse(addUserProfileUseCase.execute(input).getUserProfile());
    }
}
