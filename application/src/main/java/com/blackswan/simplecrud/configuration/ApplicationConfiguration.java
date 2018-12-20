package com.blackswan.simplecrud.configuration;

import com.blackswan.simplecrud.UserRepository;
import com.blackswan.simplecrud.adapter.UserRepositoryAdapter;
import com.blackswan.simplecrud.ports.UserPersistenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public AddUserService addUserService(UserPersistenceService userPersistenceService) {
        return new AddUserServiceAdapter(userPersistenceService);
    }

    @Bean
    public GetUserService getUserService(UserPersistenceService userPersistenceService) {
        return new GetUserServiceAdapter(userPersistenceService);
    }

    @Bean
    public UpdateUserService updateUserService(UserPersistenceService userPersistenceService) {
        return new UpdateUserServiceAdapter(userPersistenceService);
    }

    @Bean
    public UserPersistenceService userPersistenceService(UserRepository userRepository) {
        return new UserRepositoryAdapter(userRepository);
    }
}
