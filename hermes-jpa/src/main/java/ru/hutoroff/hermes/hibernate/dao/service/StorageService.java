package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.StorageDao;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;
import ru.hutoroff.hermes.model.Storage;

import java.util.List;

/**
 * Created by hutoroff on 17.07.16.
 */
public class StorageService {
    private static StorageDao accountDao;

    public StorageService() {
        accountDao = new StorageDao();
    }

    public void persist(Storage entity) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        accountDao.persist(entity);
        accountDao.closeSessionWithTransaction();
    }

    public void update(Storage entity) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        accountDao.update(entity);
        accountDao.closeSessionWithTransaction();
    }

    public void delete(Storage entity) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        accountDao.delete(entity);
        accountDao.closeSessionWithTransaction();
    }

    public List<Storage> findAll() throws DataBaseException {
        accountDao.openSessionWithTransaction();
        List<Storage> result = accountDao.findAll();
        accountDao.closeSessionWithTransaction();
        return result;
    }

    public Storage findById(Long id) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        Storage result = accountDao.findById(id);
        accountDao.closeSessionWithTransaction();
        return result;
    }
}
