package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.lib.SimpleErrorHandler;

import java.util.List;
import java.util.Optional;

public interface UserService<T> {
    Long addUser(T userEntity);

    List<T> getAllUsers();

    Optional getUser(Long userId);

    Boolean updateUser(Long id, T userEntity) throws SimpleErrorHandler;

    void deleteTask(Long id);
}
