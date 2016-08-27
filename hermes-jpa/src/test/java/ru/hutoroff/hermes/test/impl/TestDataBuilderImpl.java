package ru.hutoroff.hermes.test.impl;

import ru.hutoroff.hermes.model.*;
import ru.hutoroff.hermes.test.TestDataBuilder;
import ru.hutoroff.hermes.test.utils.TestRandomizer;

import java.util.Date;

public class TestDataBuilderImpl implements TestDataBuilder {
    private final Long ID_TEST_LONG = -1L;
    private final Integer ID_TEST_INTEGER = -1;

    @Override
    public Account getAccount() {
        Account result = createAccount(ID_TEST_LONG, TestRandomizer.generateRandomDouble(1d, Double.MAX_VALUE));
        result.setChangeUser(getUser());
        result.setCreateUser(getUser());
        result.setStorage(getStorage());
        result.setCurrency(getCurrency());

        return result;
    }

    @Override
    public Currency getCurrency() {
        return createCurrency(ID_TEST_INTEGER, "dummyCurrency");
    }

    @Override
    public Group getGroup() {
        return createGroup(ID_TEST_LONG, "dummyGroup");
    }

    @Override
    public MoneyTransaction getMoneyTransaction() {
        MoneyTransaction result = createMoneyTransaction(ID_TEST_LONG, TestRandomizer.generateRandomDouble(1d, Double.MAX_VALUE));
        result.setOwner(getUser());
        result.setAccount(getAccount());
        result.setType(getMoneyTransactionType());

        return result;
    }

    @Override
    public MoneyTransactionType getMoneyTransactionType() {
        return createMoneyTransactionType(ID_TEST_INTEGER, "dummyTransactionType", false);
    }

    @Override
    public Storage getStorage() {
        Storage result = createStorage(ID_TEST_LONG, "dummyStorage");
        result.setCreateUser(getUser());
        result.setOwner(getUser());
        result.setType(getStorageType());

        return result;
    }

    @Override
    public StorageType getStorageType() {
        return createStorageType(ID_TEST_LONG, "dummyStorageType");
    }

    @Override
    public User getUser() {
        User result = createUser(ID_TEST_LONG, "testDummyUser", "dummyPassword");
        result.setGroup(getGroup());

        return result;
    }

    private Account createAccount(Long id, Double value) {
        Account result = new Account();
        result.setId(id);
        result.setValue(value);
        result.setCreateDate(new Date());
        result.setChangeDate(new Date());
        return result;
    }

    private Currency createCurrency(Integer id, String shortName) {
        Currency result = new Currency();
        result.setId(id);
        result.setShortName(shortName);

        return result;
    }

    private Group createGroup(Long id, String groupName) {
        Group result = new Group();
        result.setId(id);
        result.setName(groupName);
        result.setCreateDate(new Date());

        return result;
    }

    private MoneyTransaction createMoneyTransaction(Long id, Double value) {
        MoneyTransaction result = new MoneyTransaction();
        result.setId(id);
        result.setCreateDate(new Date());
        result.setValue(value);

        return result;
    }

    private MoneyTransactionType createMoneyTransactionType(Integer id, String name, Boolean isDestNeeded) {
        MoneyTransactionType result = new MoneyTransactionType();
        result.setId(id);
        result.setName(name);
        result.setDestNeeded(isDestNeeded);

        return result;
    }

    private Storage createStorage(Long id, String name) {
        Storage result = new Storage();
        result.setId(id);
        result.setName(name);
        result.setCreateDate(new Date());

        return result;
    }

    private StorageType createStorageType(Long id, String name) {
        StorageType result = new StorageType();
        result.setId(id);
        result.setName(name);

        return result;
    }

    private User createUser(Long id, String login, String pass) {
        User result = new User();
        result.setId(id);
        result.setLogin(login);
        result.setPassword(pass);
        result.setCreateDate(new Date());
        result.setChangeDate(new Date());

        return result;
    }
}
