package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.hutoroff.hermes.model.Currency;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by hutoroff on 17.07.16.
 */
public class CurrencyServiceTest {

    CurrencyService underTest;
    Currency testData;

    @Before
    public void setUp() throws Exception {
        underTest = new CurrencyService();
        testData = createCurrency();
    }

    @After
    public void tearDown() throws Exception {
        if(underTest.findById(testData.getId()) != null)
            underTest.delete(testData);
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        CurrencyService currencyService = new CurrencyService();
        Currency currencyToDelete = createCurrency();
        if(currencyService.findById(currencyToDelete.getId()) != null)
            currencyService.delete(currencyToDelete);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        String excepted = "Full name";
        underTest.persist(testData);
        testData.setFullName(excepted);
        underTest.update(testData);
        Currency fromDB = underTest.findById(testData.getId());
        assertNotNull(fromDB);
        assertEquals(excepted, fromDB.getFullName());
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
        List<Currency> fromDB = underTest.findAll();
        assertNotNull(fromDB);
        assertTrue(fromDB.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        Currency actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(testData, actual);
    }

    static Currency createCurrency() {
        Currency result = new Currency();
        result.setId(1);
        result.setShortName("dummyCurrency");

        return result;
    }
}