package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.MoneyTransactionDao;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;
import ru.hutoroff.hermes.model.MoneyTransaction;

import java.util.List;

/**
 * Created by hutoroff on 18.07.16.
 */
public class MoneyTransactionService {

    private static MoneyTransactionDao moneyTransactionDao;

    public MoneyTransactionService() {
        moneyTransactionDao = new MoneyTransactionDao();
    }

    public void persist(MoneyTransaction entity) throws DataBaseException {
        moneyTransactionDao.openSessionWithTransaction();
        moneyTransactionDao.persist(entity);
        moneyTransactionDao.closeSessionWithTransaction();
    }

    public void update(MoneyTransaction entity) throws DataBaseException {
        moneyTransactionDao.openSessionWithTransaction();
        moneyTransactionDao.update(entity);
        moneyTransactionDao.closeSessionWithTransaction();
    }

    public void delete(MoneyTransaction entity) throws DataBaseException {
        moneyTransactionDao.openSessionWithTransaction();
        moneyTransactionDao.delete(entity);
        moneyTransactionDao.closeSessionWithTransaction();
    }

    public List<MoneyTransaction> findAll() throws DataBaseException {
        moneyTransactionDao.openSessionWithTransaction();
        List<MoneyTransaction> result = moneyTransactionDao.findAll();
        moneyTransactionDao.closeSessionWithTransaction();
        return result;
    }

    public MoneyTransaction findById(Long id) throws DataBaseException {
        moneyTransactionDao.openSessionWithTransaction();
        MoneyTransaction result = moneyTransactionDao.findById(id);
        moneyTransactionDao.closeSessionWithTransaction();
        return result;
    }
}
