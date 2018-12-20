package com.blackswan.simplecrud.ports;

import com.blackswan.simplecrud.entity.TaskEntity;

import java.util.List;

public interface TaskPersistenceService extends PersistenceService<TaskEntity>{
    List<TaskEntity> getByUserId(Long id);
}
