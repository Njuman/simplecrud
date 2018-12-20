package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.ports.GetUserService;
import com.blackswan.simplecrud.ports.UserPersistenceService;

import java.util.List;
import java.util.Optional;

public class GetUserServiceAdapter implements GetUserService {
    private UserPersistenceService userPersistenceService;

    public GetUserServiceAdapter(UserPersistenceService userRepository) {
        this.userPersistenceService = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userPersistenceService.getUsers();
    }

    @Override
    public Optional getUser(Long userId) {
        return userPersistenceService.getUser(userId);
    }
}
