package ru.hutoroff.hermes.factory.impl.hibernate;

import org.hibernate.Session;
import ru.hutoroff.hermes.dao.entity.*;
import ru.hutoroff.hermes.dao.entity.impl.hibernate.*;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.factory.DaoFactory;

/**
 * Created by hutoroff on 09.08.16.
 */
public class HibernateDaoFactory extends DaoFactory {

    private GenericHibernateDao instantiateDao(Class daoClass) {
        try {
            GenericHibernateDao dao = (GenericHibernateDao) daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception e) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, e);
        }
    }

    private Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public AccountDao getAccountDao() {
        return (AccountDao) instantiateDao(AccountHibernateDao.class);
    }

    @Override
    public CurrencyDao getCurrencyDao() {
        return (CurrencyDao) instantiateDao(CurrencyHibernateDao.class);
    }

    @Override
    public GroupDao getGroupDao() {
        return (GroupDao) instantiateDao(GroupHibernateDao.class);
    }

    @Override
    public MoneyTransactionDao getMoneyTransactionDao() {
        return (MoneyTransactionDao) instantiateDao(MoneyTransactionHibernateDao.class);
    }

    @Override
    public MoneyTransactionTypeDao getMoneyTrnsactionTypeDao() {
        return (MoneyTransactionTypeDao) instantiateDao(MoneyTransactionTypeHibernateDao.class);
    }

    @Override
    public StorageDao getStorageDao() {
        return (StorageDao) instantiateDao(StorageHibernateDao.class);
    }

    @Override
    public StorageTypeDao getStorageTypeDao() {
        return (StorageTypeDao) instantiateDao(StorageTypeHibernateDao.class);
    }

    @Override
    public UserDao getUserDao() {
        return (UserDao) instantiateDao(UserHibernateDao.class);
    }
}
