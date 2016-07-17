package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.*;
import ru.hutoroff.hermes.model.Group;
import ru.hutoroff.hermes.model.User;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutoroff on 16.07.16.
 */
public class UserServiceTest {

    UserService underTest;
    User testData;

    static Group groupData;

    @BeforeClass
    public static void prepareTest() throws Exception {
        groupData = GroupServiceTest.createGroup();
        GroupService groupService = new GroupService();
        if(groupService.findById(groupData.getId()) == null)
            groupService.persist(groupData);
    }

    @Before
    public void setUp() throws Exception {
        underTest = new UserService();
        testData = createUser(groupData);
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
        UserService userService = new UserService();
        GroupService groupService = new GroupService();
        User testData = createUser(groupData);
        if(userService.findById(testData.getId()) != null)
            userService.delete(testData);
        if(groupService.findById(groupData.getId()) != null)
            groupService.delete(groupData);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test
    public void delete() throws Exception {
        underTest.persist(testData);
        underTest.delete(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        String expected = "Тест";
        underTest.persist(testData);
        testData.setName(expected);
        underTest.update(testData);
        User fromDB = underTest.findById(testData.getId());
        assertNotNull(fromDB);
        String actual = fromDB.getName();
        assertEquals(actual, expected);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        User actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(actual.getId(), testData.getId());
    }

    @Test
    public void findAll() throws Exception {
        underTest.persist(testData);
        List<User> actual = underTest.findAll();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    static User createUser(Group group) {
        User result = new User();
        result.setId(1l);
        result.setLogin("dummyUser");
        result.setPassword("password");
        result.setCreateDate(new Date());
        result.setChangeDate(new Date());
        result.setGroup(group);
        return result;
    }
}