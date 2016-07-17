package ru.hutoroff.hermes.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public interface Dao<T, Id extends Serializable> {
    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();
}
