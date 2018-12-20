package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.lib.SimpleErrorHandler;

import java.util.List;
import java.util.Optional;

public interface TaskService<T>{

    Long create(Long id, T taskEntity);

    List<T> getAllTasks(Long id);

    Optional getTask(Long id);

    Boolean updateTask(Long id, T taskEntity) throws SimpleErrorHandler;

    void deleteTask(Long id);

}
