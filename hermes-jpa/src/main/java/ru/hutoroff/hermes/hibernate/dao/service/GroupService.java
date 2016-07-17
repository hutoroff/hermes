package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.GroupDao;
import ru.hutoroff.hermes.model.Group;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;

import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public class GroupService {

    private static GroupDao groupDao;

    public GroupService() {
        groupDao = new GroupDao();
    }

    public void persist(Group group) throws DataBaseException {
        groupDao.openSessionWithTransaction();
        try {
            groupDao.persist(group);
            groupDao.closeSessionWithTransaction();
        } catch (Exception e) {
            throw new DataBaseException("Persist method caused error: ",e);
        }
    }

    public void delete(Group group) throws DataBaseException {
        groupDao.openSessionWithTransaction();
        groupDao.delete(group);
        groupDao.closeSessionWithTransaction();
    }

    public void update(Group group) throws DataBaseException {
        groupDao.openSessionWithTransaction();
        groupDao.update(group);
        groupDao.closeSessionWithTransaction();
    }

    public Group findById(Long id) throws DataBaseException {
        groupDao.openSessionWithTransaction();
        Group result = groupDao.findById(id);
        groupDao.closeSessionWithTransaction();
        return result;
    }

    public List<Group> findAll() throws DataBaseException {
        groupDao.openSessionWithTransaction();
        List<Group> result = groupDao.findAll();
        groupDao.closeSessionWithTransaction();
        return result;
    }
}
