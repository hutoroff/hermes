package ru.hutoroff.hermes.test;

import ru.hutoroff.hermes.model.*;

/**
 * Interface for generator of test data
 * Created by hutoroff on 28.08.16.
 */
public interface TestDataBuilder {
    Account getAccount();

    Currency getCurrency();

    Group getGroup();

    MoneyTransaction getMoneyTransaction();

    MoneyTransactionType getMoneyTransactionType();

    Storage getStorage();

    StorageType getStorageType();

    User getUser();
}
