package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.UserDao;
import ru.hutoroff.hermes.model.User;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;

import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public class UserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void persist(User user) throws DataBaseException {
        userDao.openSessionWithTransaction();
        userDao.persist(user);
        userDao.closeSessionWithTransaction();
    }

    public void update(User user) throws DataBaseException {
        userDao.openSessionWithTransaction();
        userDao.update(user);
        userDao.closeSessionWithTransaction();
    }

    public void delete(User user) throws DataBaseException {
        userDao.openSessionWithTransaction();
        userDao.delete(user);
        userDao.closeSessionWithTransaction();
    }

    public User findById(Long id) throws DataBaseException {
        userDao.openSessionWithTransaction();
        User result = userDao.findById(id);
        userDao.closeSessionWithTransaction();
        return result;
    }

    public List<User> findAll() throws DataBaseException {
        userDao.openSessionWithTransaction();
        List<User> result = userDao.findAll();
        userDao.closeSessionWithTransaction();
        return result;
    }
}
