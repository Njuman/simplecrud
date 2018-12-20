package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.entity.TaskEntity;
import com.blackswan.simplecrud.lib.SimpleErrorHandler;
import com.blackswan.simplecrud.ports.PersistenceService;
import com.blackswan.simplecrud.ports.TaskService;

import java.util.List;
import java.util.Optional;

public class TaskServiceAdapter implements TaskService<TaskEntity> {

    private PersistenceService<TaskEntity> persistenceService;

    public TaskServiceAdapter(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public Long create(TaskEntity taskEntity) {
        if (taskEntity.getUserId() instanceof Long) {
            return persistenceService.add(taskEntity);
        }

        return (long) -1;
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return persistenceService.get();
    }

    @Override
    public Optional getTask(Long id) {
        return persistenceService.get(id);
    }

    @Override
    public Boolean updateTask(Long id, TaskEntity taskEntity) throws SimpleErrorHandler{
        if (id instanceof Long) {
            try {
                return persistenceService.update(id, taskEntity);
            } catch (Exception e) {
                throw new SimpleErrorHandler("Something went wrong: " + e);
            }
        }

        return false;
    }

    @Override
    public void deleteTask(Long id) {
        if (id instanceof Long) {
            persistenceService.delete(id);
        }
    }
}
