package com.adamjurcz.personaltrainerapp.presenters.rest.userprofiles;

import com.adamjurcz.personaltrainerapp.core.domain.Identity;
import com.adamjurcz.personaltrainerapp.core.usecases.userprofiles.AddUserProfileUseCase;
import com.adamjurcz.personaltrainerapp.core.usecases.userprofiles.GetUserProfileUseCase;
import com.adamjurcz.personaltrainerapp.presenters.rest.entities.RequestCreateUser;
import com.adamjurcz.personaltrainerapp.presenters.rest.entities.ResponseUser;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserProfileController.endpoint)
public class UserProfileController {
    public static final String endpoint = "/api/v1/users";

    private final AddUserProfileUseCase addUserProfileUseCase;
    private final GetUserProfileUseCase getUserProfileUseCase;

    public UserProfileController(AddUserProfileUseCase addUserProfileUseCase,
                                 GetUserProfileUseCase getUserProfileUseCase) {
        this.addUserProfileUseCase = addUserProfileUseCase;
        this.getUserProfileUseCase = getUserProfileUseCase;
    }

    @PostMapping
    ResponseUser addUser(@Valid @RequestBody RequestCreateUser requestCreateUser){
         AddUserProfileUseCase.Input input= new AddUserProfileUseCase.Input(requestCreateUser.getUsername(),
                 requestCreateUser.getEmail(), requestCreateUser.getPassword());
         return ResponseUser.mapToResponse(addUserProfileUseCase.execute(input).getUserProfile());
    }

    @GetMapping("/{userId}")
    ResponseUser getUserById(@PathVariable Long userId){
        GetUserProfileUseCase.Input input = new GetUserProfileUseCase.Input(new Identity(userId));
        return ResponseUser.mapToResponse(getUserProfileUseCase.execute(input).getUserProfile());
    }
}
