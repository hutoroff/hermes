package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.MoneyTransactionTypeDao;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;
import ru.hutoroff.hermes.model.MoneyTransactionType;

import java.util.List;

/**
 * Created by hutoroff on 18.07.16.
 */
public class MoneyTransactionTypeService {
    private static MoneyTransactionTypeDao moneyTransactionTypeDao;

    public MoneyTransactionTypeService() {
        moneyTransactionTypeDao = new MoneyTransactionTypeDao();
    }

    public void persist(MoneyTransactionType entity) throws DataBaseException {
        moneyTransactionTypeDao.openSessionWithTransaction();
        moneyTransactionTypeDao.persist(entity);
        moneyTransactionTypeDao.closeSessionWithTransaction();
    }

    public void update(MoneyTransactionType entity) throws DataBaseException {
        moneyTransactionTypeDao.openSessionWithTransaction();
        moneyTransactionTypeDao.update(entity);
        moneyTransactionTypeDao.closeSessionWithTransaction();
    }

    public void delete(MoneyTransactionType entity) throws DataBaseException {
        moneyTransactionTypeDao.openSessionWithTransaction();
        moneyTransactionTypeDao.delete(entity);
        moneyTransactionTypeDao.closeSessionWithTransaction();
    }

    public List<MoneyTransactionType> findAll() throws DataBaseException {
        moneyTransactionTypeDao.openSessionWithTransaction();
        List<MoneyTransactionType> result = moneyTransactionTypeDao.findAll();
        moneyTransactionTypeDao.closeSessionWithTransaction();
        return result;
    }

    public MoneyTransactionType findById(Integer id) throws DataBaseException {
        moneyTransactionTypeDao.openSessionWithTransaction();
        MoneyTransactionType result = moneyTransactionTypeDao.findById(id);
        moneyTransactionTypeDao.closeSessionWithTransaction();
        return result;
    }
}
