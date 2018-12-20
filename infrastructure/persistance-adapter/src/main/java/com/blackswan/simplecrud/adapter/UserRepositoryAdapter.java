package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.UserRepository;
import com.blackswan.simplecrud.model.User;
import com.blackswan.simplecrud.ports.UserPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserRepositoryAdapter implements UserPersistenceService {

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(UserEntity userEntity) {
        User user = new User(
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );

        userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<UserEntity> getUsers() {
       List<UserEntity> users = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            users.add(new UserEntity(
                    user.getId(),
                    user.getUsername(),
                    user.getFirstName(),
                    user.getLastName()
            ));
        });

        return users;
    }

    @Override
    public Boolean updateUser(Long id, UserEntity userEntity) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            if (userEntity.getUsername() != null) {
                user.get().setUsername(userEntity.getUsername());
            }

            if (userEntity.getFirstName() != null) {
                user.get().setFirstName(userEntity.getFirstName());
            }

            if (userEntity.getLastName() != null) {
                user.get().setLastName(userEntity.getLastName());
            }

            try {
                userRepository.save(user.get());
                return true;
            } catch (NoSuchElementException e) {
                throw e;
            }
        }

        return false;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public Optional getUser(Long id) {
        return userRepository.findById(id);
    }
}
