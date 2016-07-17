package ru.hutoroff.hermes.hibernate.dao.service;

import ru.hutoroff.hermes.hibernate.dao.impl.AccountDao;
import ru.hutoroff.hermes.model.Account;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;

import java.util.List;

/**
 * Created by hutoroff on 16.07.16.
 */
public class AccountService {

    private static AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public void persist(Account entity) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        accountDao.persist(entity);
        accountDao.closeSessionWithTransaction();
    }

    public void update(Account entity) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        accountDao.update(entity);
        accountDao.closeSessionWithTransaction();
    }

    public void delete(Account entity) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        accountDao.delete(entity);
        accountDao.closeSessionWithTransaction();
    }

    public List<Account> findAll() throws DataBaseException {
        accountDao.openSessionWithTransaction();
        List<Account> result = accountDao.findAll();
        accountDao.closeSessionWithTransaction();
        return result;
    }

    public Account findById(Long id) throws DataBaseException {
        accountDao.openSessionWithTransaction();
        Account result = accountDao.findById(id);
        accountDao.closeSessionWithTransaction();
        return result;
    }
}
