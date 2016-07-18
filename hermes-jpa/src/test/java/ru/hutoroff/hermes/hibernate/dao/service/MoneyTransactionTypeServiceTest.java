package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.hutoroff.hermes.model.MoneyTransactionType;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutoroff on 18.07.16.
 */
public class MoneyTransactionTypeServiceTest {

    private MoneyTransactionTypeService underTest;
    private MoneyTransactionType testData;

    @AfterClass
    public static void cleanUp() throws Exception {
        MoneyTransactionTypeService moneyTransactionTypeService = new MoneyTransactionTypeService();
        MoneyTransactionType moneyTransactionType = createMoneyTransactionType();

        if (moneyTransactionTypeService.findById(moneyTransactionType.getId()) != null)
            moneyTransactionTypeService.delete(moneyTransactionType);
    }

    static MoneyTransactionType createMoneyTransactionType() {
        MoneyTransactionType result = new MoneyTransactionType();
        result.setId(1);
        result.setName("dummyTransactionType");
        result.setDestNeeded(false);

        return result;
    }

    @Before
    public void setUp() throws Exception {
        underTest = new MoneyTransactionTypeService();
        testData = createMoneyTransactionType();
    }

    @After
    public void tearDown() throws Exception {
        if (underTest.findById(testData.getId()) != null)
            underTest.delete(testData);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        Boolean exepted = true;
        underTest.persist(testData);
        testData.setDestNeeded(exepted);
        underTest.update(testData);
        MoneyTransactionType actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(exepted, actual.getDestNeeded());
    }

    @Test
    public void delete() throws Exception {
        underTest.persist(testData);
        underTest.delete(testData);
        assertTrue(true);
    }

    @Test
    public void findAll() throws Exception {
        underTest.persist(testData);
        List<MoneyTransactionType> actual = underTest.findAll();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        MoneyTransactionType actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(actual, testData);
    }
}