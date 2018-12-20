package com.blackswan.simplecrud.adapter;

import com.blackswan.simplecrud.TaskRepository;
import com.blackswan.simplecrud.entity.TaskEntity;
import com.blackswan.simplecrud.model.Task;
import com.blackswan.simplecrud.ports.TaskPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TaskRepositoryAdapter implements TaskPersistenceService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskRepositoryAdapter(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Long add(TaskEntity taskEntity) {
        Task task = new Task(
                taskEntity.getUserId(),
                taskEntity.getName(),
                taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getDateTime()
        );

        taskRepository.save(task);

        return task.getId();
    }

    @Override
    public List<TaskEntity> get() {
        List<TaskEntity> tasks = new ArrayList<>();

        taskRepository.findAll().forEach(task -> {
            tasks.add(new TaskEntity(
                    task.getId(),
                    task.getUserId(),
                    task.getName(),
                    task.getDescription(),
                    task.getStatus(),
                    task.getDateTime()
            ));
        });

        return tasks;
    }

    @Override
    public Boolean update(Long id, TaskEntity taskEntity) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            if (taskEntity.getUserId() != null) {
                task.get().setUserId(taskEntity.getUserId());
            }

            if (taskEntity.getName() != null) {
                task.get().setName(taskEntity.getName());
            }

            if (taskEntity.getDescription() != null) {
                task.get().setDescription(taskEntity.getDescription());
            }

            if (taskEntity.getStatus() != null) {
                task.get().setStatus(taskEntity.getStatus());
            }

            try {
                taskRepository.save(task.get());
                return true;
            } catch (NoSuchElementException e) {
                throw e;
            }
        }

        return false;
    }

    @Override
    public Optional get(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<TaskEntity> getByUserId(Long id) {
        List<TaskEntity> tasks = new ArrayList<>();

        taskRepository.findAllByUserId(id).forEach(task -> {
            tasks.add(new TaskEntity(
                    task.getId(),
                    task.getUserId(),
                    task.getName(),
                    task.getDescription(),
                    task.getStatus(),
                    task.getDateTime()
            ));
        });

        return tasks;
    }

    @Override
    public void delete(Long id) {
        taskRepository.delete(taskRepository.findById(id).get());
    }
}
