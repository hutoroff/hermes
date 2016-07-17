package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.hutoroff.hermes.model.Group;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutoroff on 16.07.16.
 */
public class GroupServiceTest {

    private GroupService underTest;
    private Group testData;

    @Before
    public void setUp() throws Exception {
        underTest = new GroupService();
        testData = createGroup();
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
        GroupService underTest = new GroupService();
        Group testData = createGroup();
        if(underTest.findById(testData.getId()) != null)
            underTest.delete(testData);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test(expected = DataBaseException.class)
    public void persist_duplicate() throws Exception {
        underTest.persist(testData);
        underTest.persist(testData);
    }

    @Test
    public void delete() throws Exception {
        underTest.persist(testData);
        underTest.delete(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        String expected = "changedName";
        if(underTest.findById(testData.getId()) == null)
            underTest.persist(testData);
        testData.setFormalName(expected);
        underTest.update(testData);
        Group group = underTest.findById(testData.getId());
        assertNotNull(group);
        assertEquals(expected, group.getFormalName());
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        Group actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(actual.getId(), testData.getId());
    }

    @Test
    public void findAll() throws Exception {
        if(underTest.findById(testData.getId()) == null)
            underTest.persist(testData);
        List<Group> actual = underTest.findAll();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    static Group createGroup() {
        Group result = new Group();
        result.setId(1l);
        result.setName("dummyGroup");
        result.setCreateDate(new Date());
        return result;
    }
}