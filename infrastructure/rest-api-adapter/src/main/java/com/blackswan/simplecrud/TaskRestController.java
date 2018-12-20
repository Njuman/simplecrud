package com.blackswan.simplecrud;

import com.blackswan.simplecrud.entity.UserEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class TaskRestController {



    @RequestMapping(value = "/api/user/{id}/task", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> getUserTasks() {
        
    }

}
