package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserPersistenceService {

    Long addUser(UserEntity userEntity);

    Boolean updateUser(Long id, UserEntity userEntity);

    List<UserEntity> getUsers();

    void deleteUser(int id);

    Optional getUser(Long userId);

}
