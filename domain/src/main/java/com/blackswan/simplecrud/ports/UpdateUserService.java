package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.lib.SimpleErrorHandler;

public interface UpdateUserService {
    Boolean updateUser(Long id, UserEntity userEntity) throws SimpleErrorHandler;
}
