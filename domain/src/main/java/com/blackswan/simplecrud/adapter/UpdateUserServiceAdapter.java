package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.lib.SimpleErrorHandler;
import com.blackswan.simplecrud.ports.UpdateUserService;
import com.blackswan.simplecrud.ports.UserPersistenceService;

public class UpdateUserServiceAdapter implements UpdateUserService {

    private UserPersistenceService userPersistenceService;

    public UpdateUserServiceAdapter(UserPersistenceService userRepository) {
        this.userPersistenceService = userRepository;
    }

    public Boolean updateUser(Long id, UserEntity userEntity) throws SimpleErrorHandler{
        if (id != null) {
            try {
                return userPersistenceService.updateUser(id, userEntity);
            } catch (Exception e) {
                throw new SimpleErrorHandler("Something went wrong: " + e);
            }
        }

        return false;
    }
}
