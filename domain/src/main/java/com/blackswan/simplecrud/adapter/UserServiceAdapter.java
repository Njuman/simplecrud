package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.lib.SimpleErrorHandler;
import com.blackswan.simplecrud.ports.UserPersistenceService;
import com.blackswan.simplecrud.ports.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceAdapter implements UserService<UserEntity> {

    private UserPersistenceService persistenceService;

    public UserServiceAdapter(UserPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public Long addUser(UserEntity user) {
        if (user.getUsername().length() != 0) {
            return persistenceService.add(user);
        }

        return (long) -1;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return persistenceService.get();
    }

    @Override
    public Optional getUser(Long userId) {
        return persistenceService.get(userId);
    }

    @Override
    public Boolean updateUser(Long id, UserEntity userEntity) throws SimpleErrorHandler {
        if (id != null) {
            try {
                return persistenceService.update(id, userEntity);
            } catch (Exception e) {
                throw new SimpleErrorHandler("Something went wrong: " + e);
            }
        }

        return false;
    }

    @Override
    public void deleteUser(Long id) {
        if (id instanceof Long) {
            persistenceService.delete(id);
        }
    }
}
