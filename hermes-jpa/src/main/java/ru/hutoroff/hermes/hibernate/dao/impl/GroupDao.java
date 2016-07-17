package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.Group;

import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public class GroupDao extends SessionService implements Dao<Group, Long>{

    public GroupDao() {
    }

    public void persist(Group entitiy) {
        session.save(entitiy);
    }

    public void update(Group entity) {
        session.update(entity);
    }

    public Group findById(Long id) {
        return session.find(Group.class, id);
    }

    public void delete(Group entity) {
        session.delete(entity);
    }

    public List<Group> findAll() {
        return (List<Group>) session.createQuery("from Group ").list();
    }
}
