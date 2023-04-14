package com.adamjurcz.personaltrainerapp.presenters.config;

import com.adamjurcz.personaltrainerapp.core.usecases.userprofiles.AddUserProfileUseCase;
import com.adamjurcz.personaltrainerapp.core.usecases.userprofiles.UserProfileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    AddUserProfileUseCase addUserProfileUseCase(UserProfileRepository repository){
        return new AddUserProfileUseCase(repository);
    }
}
