package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface GetUserService {

    List<UserEntity> getAllUsers();

    Optional getUser(Long userId);

}
