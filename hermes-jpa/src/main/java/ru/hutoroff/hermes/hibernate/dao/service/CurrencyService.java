package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.CurrencyDao;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;
import ru.hutoroff.hermes.model.Currency;

import java.util.List;

/**
 * Created by hutoroff on 17.07.16.
 */
public class CurrencyService {
    private static CurrencyDao currencyDao;

    public CurrencyService() {
        currencyDao = new CurrencyDao();
    }

    public void persist(Currency entity) throws DataBaseException {
        currencyDao.openSessionWithTransaction();
        currencyDao.persist(entity);
        currencyDao.closeSessionWithTransaction();
    }

    public void update(Currency entity) throws DataBaseException {
        currencyDao.openSessionWithTransaction();
        currencyDao.update(entity);
        currencyDao.closeSessionWithTransaction();
    }

    public void delete(Currency entity) throws DataBaseException {
        currencyDao.openSessionWithTransaction();
        currencyDao.delete(entity);
        currencyDao.closeSessionWithTransaction();
    }

    public List<Currency> findAll() throws DataBaseException {
        currencyDao.openSessionWithTransaction();
        List<Currency> result = currencyDao.findAll();
        currencyDao.closeSessionWithTransaction();
        return result;
    }

    public Currency findById(Integer id) throws DataBaseException {
        currencyDao.openSessionWithTransaction();
        Currency result = currencyDao.findById(id);
        currencyDao.closeSessionWithTransaction();
        return result;
    }
}
