package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.lib.SimpleErrorHandler;

import java.util.List;
import java.util.Optional;

public interface TaskService<T>{

    Long create(T taskEntity);

    List<T> getAllTasks();

    Optional getTask(Long userId);

    Boolean updateTask(Long id, T taskEntity) throws SimpleErrorHandler;

    void deleteTask(Long id);

}
