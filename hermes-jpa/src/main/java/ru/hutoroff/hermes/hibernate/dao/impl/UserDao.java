package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.User;

import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public class UserDao extends SessionService implements Dao<User, Long> {

    public UserDao() {
    }

    public void persist(User entitiy) {
        session.save(entitiy);
    }

    public void update(User entity) {
        session.update(entity);
    }

    public User findById(Long id) {
        return session.find(User.class, id);
    }

    public void delete(User entity) {
        session.delete(entity);
    }

    public List<User> findAll() {
        return (List<User>) session.createQuery("from User").list();
    }

}
