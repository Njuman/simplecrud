package com.blackswan.simplecrud.ports;

import java.util.List;
import java.util.Optional;

public interface TaskPersistenceService<T> {
    Long add(T taskEntity);

    List<T> get();

    Boolean update(Long id, T taskEntity);

    void delete(int id);

    Optional get(Long userId);

    Boolean delete(Long id);
}
