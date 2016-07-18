package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.MoneyTransaction;

import java.util.List;

/**
 * Created by hutoroff on 18.07.16.
 */
public class MoneyTransactionDao extends SessionService implements Dao<MoneyTransaction, Long> {

    public void persist(MoneyTransaction entity) {
        session.save(entity);
    }

    public void update(MoneyTransaction entity) {
        session.update(entity);
    }

    public MoneyTransaction findById(Long id) {
        return session.find(MoneyTransaction.class, id);
    }

    public void delete(MoneyTransaction entity) {
        session.delete(entity);
    }

    public List<MoneyTransaction> findAll() {
        return (List<MoneyTransaction>) session.createQuery("from MoneyTransaction").list();
    }
}
