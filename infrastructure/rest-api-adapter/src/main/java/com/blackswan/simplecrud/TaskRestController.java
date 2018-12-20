package com.blackswan.simplecrud;

import com.blackswan.simplecrud.entity.TaskEntity;
import com.blackswan.simplecrud.lib.SimpleErrorHandler;
import com.blackswan.simplecrud.ports.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskRestController {

    private TaskService<TaskEntity> taskService;

    @Autowired
    public TaskRestController(TaskService<TaskEntity> taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/api/user/{userId}/task", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addTask(@PathVariable Long userId, @RequestBody TaskEntity taskEntity) {
        Long TaskId = taskService.create(userId, taskEntity);
        if (TaskId > 0) {
            return new ResponseEntity("{\"id\": " + TaskId + "}", HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/user/{userId}/task", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskEntity> getTasks(@PathVariable Long userId) {
        return taskService.getAllTasks(userId);
    }

    @RequestMapping(value = "/api/user/{userId}/task/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTask(@PathVariable Long id) {
        Optional possibleTask = taskService.getTask(id);

        if (possibleTask.isPresent()) {
            return new ResponseEntity(possibleTask.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/api/user/{userId}/task/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask(@PathVariable Long id, @RequestBody TaskEntity taskEntity) {
        try {
            Boolean response = taskService.updateTask(id, taskEntity);

            if (response) {
                return new ResponseEntity("{\"message\": \"Task Successfully Updated\" }", HttpStatus.ACCEPTED);
            }
        } catch (SimpleErrorHandler e) {
            return new ResponseEntity(e.toJson(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/user/{userId}/task/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
