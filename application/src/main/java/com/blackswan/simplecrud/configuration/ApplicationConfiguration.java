package com.blackswan.simplecrud.configuration;

import com.blackswan.simplecrud.TaskRepository;
import com.blackswan.simplecrud.UserRepository;
import com.blackswan.simplecrud.entity.TaskEntity;
import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.adapter.TaskRepositoryAdapter;
import com.blackswan.simplecrud.adapter.TaskServiceAdapter;
import com.blackswan.simplecrud.adapter.UserRepositoryAdapter;
import com.blackswan.simplecrud.adapter.UserServiceAdapter;
import com.blackswan.simplecrud.ports.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public UserService userService(UserPersistenceService persistenceService) {
        return new UserServiceAdapter(persistenceService);
    }

    @Bean
    public UserPersistenceService persistenceService(UserRepository userRepository) {
        return new UserRepositoryAdapter(userRepository);
    }

    @Bean
    public TaskService taskService(TaskPersistenceService persistenceService) {
        return new TaskServiceAdapter(persistenceService);
    }

    @Bean
    public TaskPersistenceService taskPersistenceService(TaskRepository taskRepository) {
        return new TaskRepositoryAdapter(taskRepository);
    }
}
