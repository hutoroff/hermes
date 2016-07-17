package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;
import ru.hutoroff.hermes.model.StorageType;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutoroff on 17.07.16.
 */
public class StorageTypeServiceTest {

    StorageTypeService underTest;
    StorageType testData;

    @Before
    public void setUp() throws Exception {
        underTest = new StorageTypeService();
        testData = createStorageType();
    }

    @After
    public void tearDown() throws Exception {
        try {
            if (underTest.findById(testData.getId()) != null)
                underTest.delete(testData);
        } catch (DataBaseException e) {}
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        StorageTypeService storageTypeService = new StorageTypeService();
        StorageType dataToDelete = createStorageType();
        if(storageTypeService.findById(dataToDelete.getId()) != null)
            storageTypeService.delete(dataToDelete);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        String expected = "Dummy comment";
        underTest.persist(testData);
        testData.setComment(expected);
        underTest.update(testData);
        StorageType typeFromDB = underTest.findById(testData.getId());
        assertNotNull(typeFromDB);
        assertEquals(typeFromDB.getComment(), expected);
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
        List<StorageType> actual = underTest.findAll();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        StorageType actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(testData, actual);
    }

    static StorageType createStorageType() {
        StorageType result = new StorageType();
        result.setId(1l);
        result.setName("dummyStorageType");

        return result;
    }
}