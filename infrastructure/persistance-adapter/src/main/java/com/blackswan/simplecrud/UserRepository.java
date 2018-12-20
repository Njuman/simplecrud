package com.blackswan.simplecrud;

import com.blackswan.simplecrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
