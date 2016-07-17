package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.*;
import ru.hutoroff.hermes.model.Group;
import ru.hutoroff.hermes.model.Storage;
import ru.hutoroff.hermes.model.StorageType;
import ru.hutoroff.hermes.model.User;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by hutoroff on 17.07.16.
 */
public class StorageServiceTest {

    StorageService underTest;
    Storage testData;

    private static User userData;
    private static Group groupData;
    private static StorageType storageTypeData;

    @BeforeClass
    public static void prepareTest() throws Exception {
        groupData = GroupServiceTest.createGroup();
        GroupService groupService = new GroupService();
        if(groupService.findById(groupData.getId()) == null)
            groupService.persist(groupData);

        userData = UserServiceTest.createUser(groupData);
        UserService userService = new UserService();
        if(userService.findById(userData.getId()) == null)
            userService.persist(userData);

        storageTypeData = StorageTypeServiceTest.createStorageType();
        StorageTypeService storageTypeService = new StorageTypeService();
        if(storageTypeService.findById(storageTypeData.getId()) == null)
            storageTypeService.persist(storageTypeData);
    }

    @Before
    public void setUp() throws Exception {
        underTest = new StorageService();
        testData = createStorage(userData, storageTypeData);
    }

    @After
    public void tearDown() throws Exception {
        if(underTest.findById(testData.getId()) != null)
            underTest.delete(testData);
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        StorageService storageService = new StorageService();
        Storage dataToClean = createStorage(userData, storageTypeData);
        UserService userService = new UserService();
        GroupService groupService = new GroupService();
        StorageTypeService storageTypeService = new StorageTypeService();

        if(storageService.findById(dataToClean.getId()) != null)
            storageService.delete(dataToClean);

        if(userService.findById(userData.getId()) != null)
            userService.delete(userData);

        if(groupService.findById(groupData.getId()) != null)
            groupService.delete(groupData);

        if(storageTypeService.findById(storageTypeData.getId()) != null)
            storageTypeService.delete(storageTypeData);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        String excepted = "newName";
        underTest.persist(testData);
        testData.setName(excepted);
        underTest.update(testData);
        Storage fromDB = underTest.findById(testData.getId());
        assertNotNull(fromDB);
        assertEquals(testData.getName(),excepted);
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
        List<Storage> storages = underTest.findAll();
        assertNotNull(storages);
        assertTrue(storages.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        Storage fromDB = underTest.findById(testData.getId());
        assertNotNull(fromDB);
        assertEquals(fromDB.getId(), testData.getId());
    }

    static Storage createStorage(User user, StorageType storageType) {
        Storage result = new Storage();
        result.setId(1l);
        result.setName("dummyStorage");
        result.setCreateUser(user);
        result.setOwner(user);
        result.setCreateDate(new Date());
        result.setType(storageType);

        return result;
    }
}