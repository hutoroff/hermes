package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.Storage;

import java.util.List;

/**
 * Created by hutoroff on 17.07.16.
 */
public class StorageDao extends SessionService implements Dao<Storage, Long> {
    public void persist(Storage entitiy) {
        session.save(entitiy);
    }

    public void update(Storage entity) {
        session.update(entity);
    }

    public Storage findById(Long id) {
        return session.find(Storage.class, id);
    }

    public void delete(Storage entity) {
        session.delete(entity);
    }

    public List<Storage> findAll() {
        return (List<Storage>) session.createQuery("from Storage").list();
    }
}
