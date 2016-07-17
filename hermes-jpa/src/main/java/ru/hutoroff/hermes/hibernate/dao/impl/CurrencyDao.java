package ru.hutoroff.hermes.hibernate.dao.impl;

import ru.hutoroff.hermes.hibernate.dao.Dao;
import ru.hutoroff.hermes.hibernate.dao.SessionService;
import ru.hutoroff.hermes.model.Currency;

import java.util.List;

/**
 * Created by hutoroff on 17.07.16.
 */
public class CurrencyDao extends SessionService implements Dao<Currency, Integer> {

    public CurrencyDao() {
    }

    public void persist(Currency entity) {
        session.save(entity);
    }

    public void update(Currency entity) {
        session.update(entity);
    }

    public Currency findById(Integer id) {
        return session.find(Currency.class, id);
    }

    public void delete(Currency entity) {
        session.delete(entity);
    }

    public List<Currency> findAll() {
        return (List<Currency>) session.createQuery("from Currency").list();
    }
}
