package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.ports.AddUserService;
import com.blackswan.simplecrud.ports.UserPersistenceService;

public class AddUserServiceAdapter implements AddUserService {

    private UserPersistenceService userPersistenceService;

    public AddUserServiceAdapter(UserPersistenceService userRepository) {
        this.userPersistenceService = userRepository;
    }

    @Override
    public Long addUser(UserEntity user) {
        if (user.getUsername().length() != 0) {
            return userPersistenceService.addUser(user);
        }

        return (long) -1;
    }
}
