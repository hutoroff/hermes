package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.MoneyTransactionType;

import java.util.List;

/**
 * Created by hutoroff on 18.07.16.
 */
public class MoneyTransactionTypeDao extends SessionService implements Dao<MoneyTransactionType, Integer> {
    public void persist(MoneyTransactionType entity) {
        session.save(entity);
    }

    public void update(MoneyTransactionType entity) {
        session.update(entity);
    }

    public MoneyTransactionType findById(Integer id) {
        return session.find(MoneyTransactionType.class, id);
    }

    public void delete(MoneyTransactionType entity) {
        session.delete(entity);
    }

    public List<MoneyTransactionType> findAll() {
        return (List<MoneyTransactionType>) session.createQuery("from MoneyTransactionType").list();
    }
}
