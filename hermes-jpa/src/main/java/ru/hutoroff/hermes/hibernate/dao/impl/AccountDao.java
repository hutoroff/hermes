package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.Account;

import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public class AccountDao extends SessionService implements Dao<Account, Long> {

    public AccountDao() {
    }

    public void persist(Account entity) {
        session.save(entity);
    }

    public void update(Account entity) {
        session.update(entity);
    }

    public Account findById(Long id) {
        return session.get(Account.class, id);
    }

    public void delete(Account entity) {
        session.delete(entity);
    }

    public List<Account> findAll() {
        return (List<Account>) session.createQuery("from Account").list();
    }
}
