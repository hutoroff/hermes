package ru.hutoroff.hermes.factory.impl.hibernate;

import org.junit.Before;
import org.junit.Test;
import ru.hutoroff.hermes.dao.entity.*;
import ru.hutoroff.hermes.factory.DaoFactory;

import static org.junit.Assert.assertNotNull;

public class HibernateDaoFactoryTest {

    private DaoFactory daoFactory;

    @Before
    public void setUp() throws Exception {
        daoFactory = DaoFactory.getInstance(DaoFactory.HIBERNATE);
    }

    @Test
    public void getAccountDaoTest() throws Exception {
        AccountDao accountDao = daoFactory.getAccountDao();
        assertNotNull(accountDao);
    }

    @Test
    public void getCurrencyDaoTest() throws Exception {
        CurrencyDao currencyDao = daoFactory.getCurrencyDao();
        assertNotNull(currencyDao);
    }

    @Test
    public void getGroupDaoTest() throws Exception {
        GroupDao groupDao = daoFactory.getGroupDao();
        assertNotNull(groupDao);
    }

    @Test
    public void getMoneyTransactionDaoTest() throws Exception {
        MoneyTransactionDao moneyTransactionDao = daoFactory.getMoneyTransactionDao();
        assertNotNull(moneyTransactionDao);
    }

    @Test
    public void getMoneyTransactionTypeDaoTest() throws Exception {
        MoneyTransactionTypeDao moneyTransactionTypeDao = daoFactory.getMoneyTrnsactionTypeDao();
        assertNotNull(moneyTransactionTypeDao);
    }

    @Test
    public void getStorageDaoTest() throws Exception {
        StorageDao storageDao = daoFactory.getStorageDao();
        assertNotNull(storageDao);
    }

    @Test
    public void getStorageTypeTest() throws Exception {
        StorageTypeDao storageTypeDao = daoFactory.getStorageTypeDao();
        assertNotNull(storageTypeDao);
    }

    @Test
    public void getUserDaoTest() throws Exception {
        UserDao userDao = daoFactory.getUserDao();
        assertNotNull(userDao);
    }
}