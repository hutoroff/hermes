package ru.hutoroff.hermes.factory;

import ru.hutoroff.hermes.dao.entity.*;
import ru.hutoroff.hermes.exception.DataBaseException;
import ru.hutoroff.hermes.factory.impl.hibernate.HibernateDaoFactory;

/**
 * Created by hutoroff on 22.08.16.
 */
public abstract class DaoFactory {
    public static final Class HIBERNATE = HibernateDaoFactory.class;

    public static DaoFactory getInstance(Class factory) throws DataBaseException {
        try {
            return (DaoFactory) factory.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DataBaseException("Could not create DAO factory. Caused by: ", e);
        }
    }

    public static DaoFactory getInstance() throws DataBaseException {
        try {
            return (DaoFactory) HIBERNATE.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DataBaseException("Could not create DAO factory. Caused by: ", e);
        }
    }

    public abstract AccountDao getAccountDao();

    public abstract CurrencyDao getCurrencyDao();

    public abstract GroupDao getGroupDao();

    public abstract MoneyTransactionDao getMoneyTransactionDao();

    public abstract MoneyTransactionTypeDao getMoneyTrnsactionTypeDao();

    public abstract StorageDao getStorageDao();

    public abstract StorageTypeDao getStorageTypeDao();

    public abstract UserDao getUserDao();
}
