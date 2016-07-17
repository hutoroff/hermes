package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.StorageTypeDao;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;
import ru.hutoroff.hermes.model.StorageType;

import java.util.List;

/**
 * Created by hutoroff on 17.07.16.
 */
public class StorageTypeService {
    private static StorageTypeDao storageTypeDao;

    public StorageTypeService() {
        storageTypeDao = new StorageTypeDao();
    }

    public void persist(StorageType entity) throws DataBaseException {
        storageTypeDao.openSessionWithTransaction();
        storageTypeDao.persist(entity);
        storageTypeDao.closeSessionWithTransaction();
    }

    public void update(StorageType entity) throws DataBaseException {
        storageTypeDao.openSessionWithTransaction();
        storageTypeDao.update(entity);
        storageTypeDao.closeSessionWithTransaction();
    }

    public void delete(StorageType entity) throws DataBaseException {
        storageTypeDao.openSessionWithTransaction();
        storageTypeDao.delete(entity);
        storageTypeDao.closeSessionWithTransaction();
    }

    public List<StorageType> findAll() throws DataBaseException {
        storageTypeDao.openSessionWithTransaction();
        List<StorageType> result = storageTypeDao.findAll();
        storageTypeDao.closeSessionWithTransaction();
        return result;
    }

    public StorageType findById(Long id) throws DataBaseException {
        storageTypeDao.openSessionWithTransaction();
        StorageType result = storageTypeDao.findById(id);
        storageTypeDao.closeSessionWithTransaction();
        return result;
    }    
}
