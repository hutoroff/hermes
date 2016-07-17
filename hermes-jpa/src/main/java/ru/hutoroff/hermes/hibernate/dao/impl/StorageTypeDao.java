package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.StorageType;

import java.util.List;

/**
 * Created by hutoroff on 17.07.16.
 */
public class StorageTypeDao extends SessionService implements Dao<StorageType, Long> {
    public void persist(StorageType entity) {
        session.save(entity);
    }

    public void update(StorageType entity) {
        session.update(entity);
    }

    public StorageType findById(Long id) {
        return session.find(StorageType.class, id);
    }

    public void delete(StorageType entity) {
        session.delete(entity);
    }

    public List<StorageType> findAll() {
        return (List<StorageType>) session.createQuery("from StorageType ").list();
    }
}
