package com.blackswan.simplecrud.ports;

import java.util.List;
import java.util.Optional;

public interface PersistenceService<T> {
    Long add(T entity);

    List<T> get();

    Boolean update(Long id, T entity);

    Optional get(Long id);

    void delete(Long id);
}
