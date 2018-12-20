package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.entity.UserEntity;


public interface AddUserService {
    Long addUser(UserEntity newUser);
}
