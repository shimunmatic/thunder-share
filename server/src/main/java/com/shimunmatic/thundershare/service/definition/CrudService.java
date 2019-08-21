package com.shimunmatic.thundershare.service.definition;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, U> {

    Optional<T> getById(U id);

    List<T> getAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(U id);
}
