package com.blackswan.simplecrud.configuration;

import com.blackswan.simplecrud.UserRepository;
import com.blackswan.simplecrud.adapter.UpdateUserServiceAdapter;
import com.blackswan.simplecrud.adapter.UserRepositoryAdapter;
import com.blackswan.simplecrud.ports.AddUserService;
import com.blackswan.simplecrud.ports.GetUserService;
import com.blackswan.simplecrud.ports.UpdateUserService;
import com.blackswan.simplecrud.ports.UserPersistenceService;
import com.blackswan.simplecrud.adapter.AddUserServiceAdapter;
import com.blackswan.simplecrud.adapter.GetUserServiceAdapter;
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
