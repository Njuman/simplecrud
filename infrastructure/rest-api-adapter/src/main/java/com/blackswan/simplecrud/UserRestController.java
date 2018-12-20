package com.blackswan.simplecrud;

import com.blackswan.simplecrud.entity.UserEntity;
import com.blackswan.simplecrud.lib.SimpleErrorHandler;
import com.blackswan.simplecrud.ports.AddUserService;
import com.blackswan.simplecrud.ports.GetUserService;
import com.blackswan.simplecrud.ports.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    private GetUserService getUserService;

    private AddUserService addUserService;

    private UpdateUserService updateUserService;

    @Autowired
    public UserRestController(
            GetUserService getUserService,
            AddUserService addUserService,
            UpdateUserService updateUserService
    ) {
        this.getUserService = getUserService;
        this.addUserService = addUserService;
        this.updateUserService = updateUserService;
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> getUsers() {
        return getUserService.getAllUsers();
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUser(@PathVariable Long id) {
        Optional possibleUser = getUserService.getUser(id);

        if (possibleUser.isPresent()) {
            return new ResponseEntity(possibleUser.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody UserEntity user) {
        Long userId = addUserService.addUser(user);
        if (userId > 0) {
            return new ResponseEntity("{\"id\": " + userId + "}", HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        try {
            Boolean response = updateUserService.updateUser(id, user);

            if (response) {
                return new ResponseEntity("{\"message\": \"Successfully Updated\" }", HttpStatus.ACCEPTED);
            }
        } catch (SimpleErrorHandler e) {
            return new ResponseEntity(e.toJson(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
