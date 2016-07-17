package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.*;
import ru.hutoroff.hermes.model.*;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutoroff on 16.07.16.
 */
public class AccountServiceTest {

    private AccountService underTest;
    private Account testData;

    private static Group groupData;
    private static User userData;
    private static StorageType storageTypeData;
    private static Storage storageData;
    private static Currency currencyData;

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

        storageData = StorageServiceTest.createStorage(userData, storageTypeData);
        StorageService storageService = new StorageService();
        if(storageService.findById(storageData.getId()) == null)
            storageService.persist(storageData);

        currencyData = CurrencyServiceTest.createCurrency();
        CurrencyService currencyService = new CurrencyService();
        if(currencyService.findById(currencyData.getId()) == null)
            currencyService.persist(currencyData);
    }

    @Before
    public void setUp() throws Exception {
        underTest = new AccountService();
        testData = createAccount(userData, storageData, currencyData);
    }

    @After
    public void tearDown() throws Exception {
        if (underTest.findById(testData.getId()) != null)
            underTest.delete(testData);
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        AccountService accountService = new AccountService();
        Account accountToDelete = createAccount(userData, storageData, currencyData);
        if(accountService.findById(accountToDelete.getId()) != null)
            accountService.delete(accountToDelete);

        GroupService groupService = new GroupService();
        if(groupService.findById(groupData.getId()) != null)
            groupService.delete(groupData);

        UserService userService = new UserService();
        if(userService.findById(userData.getId()) != null)
            userService.delete(userData);

        StorageTypeService storageTypeService = new StorageTypeService();
        if(storageTypeService.findById(storageTypeData.getId()) != null)
            storageTypeService.delete(storageTypeData);

        StorageService storageService = new StorageService();
        if(storageService.findById(storageData.getId()) != null)
            storageService.delete(storageData);

        CurrencyService currencyService = new CurrencyService();
        if(currencyService.findById(currencyData.getId()) != null)
            currencyService.delete(currencyData);
    }

    @Test
    public void persist() throws Exception {
        underTest.persist(testData);
        assertTrue(true);
    }

    @Test
    public void update() throws Exception {
        User excepted = userData;
        underTest.persist(testData);
        testData.setChangeUser(excepted);
        underTest.update(testData);
        Account actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(excepted.getLogin(), actual.getChangeUser().getLogin());
    }

    @Test
    public void findAll() throws Exception {
        underTest.persist(testData);
        List<Account> actual = underTest.findAll();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        Account actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(actual.getId(), testData.getId());
    }

    static Account createAccount(User user, Storage storage, Currency currency) {
        Account account = new Account();
        account.setId(1l);
        account.setValue(200d);
        account.setCreateDate(new Date());
        account.setChangeDate(new Date());
        account.setCreateUser(user);
        account.setStorage(storage);
        account.setCurrency(currency);
        return account;
    }
}