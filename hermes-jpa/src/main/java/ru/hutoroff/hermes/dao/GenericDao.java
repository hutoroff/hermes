package ru.hutoroff.hermes.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public interface GenericDao<T, Id extends Serializable> {
    void persist(T entity);

    void update(T entity);

    T findById(Id id, boolean lock);

    void delete(T entity);

    List<T> findAll();

    List<T> findByExample(T exampleInstance, String[] excludeProperty);

    T makePersitent(T entity);

    void makeTransient(T entity);
}
