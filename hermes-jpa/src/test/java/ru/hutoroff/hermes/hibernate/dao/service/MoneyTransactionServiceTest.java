package ru.hutoroff.hermes.hibernate.dao.service;

import org.junit.*;
import ru.hutoroff.hermes.model.*;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutoroff on 18.07.16.
 */
public class MoneyTransactionServiceTest {

    private static User userData;
    private static Group groupData;
    private static Account accountData;
    private static Storage storageData;
    private static Currency currencyData;
    private static StorageType storageTypeData;
    private static MoneyTransactionType typeData;
    private MoneyTransactionService underTest;
    private MoneyTransaction testData;

    @BeforeClass
    public static void prepareClass() throws Exception {
        groupData = GroupServiceTest.createGroup();
        GroupService groupService = new GroupService();
        if (groupService.findById(groupData.getId()) == null)
            groupService.persist(groupData);

        userData = UserServiceTest.createUser(groupData);
        UserService userService = new UserService();
        if (userService.findById(userData.getId()) == null)
            userService.persist(userData);

        storageTypeData = StorageTypeServiceTest.createStorageType();
        StorageTypeService storageTypeService = new StorageTypeService();
        if (storageTypeService.findById(storageTypeData.getId()) == null)
            storageTypeService.persist(storageTypeData);

        storageData = StorageServiceTest.createStorage(userData, storageTypeData);
        StorageService storageService = new StorageService();
        if (storageService.findById(storageData.getId()) == null)
            storageService.persist(storageData);

        currencyData = CurrencyServiceTest.createCurrency();
        CurrencyService currencyService = new CurrencyService();
        if (currencyService.findById(currencyData.getId()) == null)
            currencyService.persist(currencyData);

        accountData = AccountServiceTest.createAccount(userData, storageData, currencyData);
        AccountService accountService = new AccountService();
        if (accountService.findById(accountData.getId()) == null)
            accountService.persist(accountData);

        typeData = MoneyTransactionTypeServiceTest.createMoneyTransactionType();
        MoneyTransactionTypeService moneyTransactionTypeService = new MoneyTransactionTypeService();
        if (moneyTransactionTypeService.findById(typeData.getId()) == null)
            moneyTransactionTypeService.persist(typeData);
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        MoneyTransactionService moneyTransactionService = new MoneyTransactionService();
        MoneyTransaction moneyTransaction = createMoneyTransaction(userData, accountData, typeData);
        if (moneyTransactionService.findById(moneyTransaction.getId()) != null)
            moneyTransactionService.delete(moneyTransaction);

        MoneyTransactionTypeService moneyTransactionTypeService = new MoneyTransactionTypeService();
        if (moneyTransactionTypeService.findById(typeData.getId()) != null)
            moneyTransactionTypeService.delete(typeData);

        AccountService accountService = new AccountService();
        if (accountService.findById(accountData.getId()) != null)
            accountService.delete(accountData);

        CurrencyService currencyService = new CurrencyService();
        if (currencyService.findById(currencyData.getId()) != null)
            currencyService.delete(currencyData);

        StorageService storageService = new StorageService();
        if (storageService.findById(storageData.getId()) != null)
            storageService.delete(storageData);

        StorageTypeService storageTypeService = new StorageTypeService();
        if (storageTypeService.findById(storageTypeData.getId()) != null)
            storageTypeService.delete(storageTypeData);

        UserService userService = new UserService();
        if (userService.findById(userData.getId()) != null)
            userService.delete(userData);

        GroupService groupService = new GroupService();
        if (groupService.findById(groupData.getId()) != null)
            groupService.delete(groupData);
    }

    static MoneyTransaction createMoneyTransaction(User owner, Account account, MoneyTransactionType type) {
        MoneyTransaction result = new MoneyTransaction();
        result.setId(1l);
        result.setCreateDate(new Date());
        result.setValue(1d);
        result.setOwner(owner);
        result.setAccount(account);
        result.setType(type);

        return result;
    }

    @Before
    public void setUp() throws Exception {
        underTest = new MoneyTransactionService();
        testData = createMoneyTransaction(userData, accountData, typeData);
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
        String excepted = "dummy comment";
        underTest.persist(testData);
        testData.setComment(excepted);
        underTest.update(testData);
        MoneyTransaction actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(actual.getComment(), excepted);
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
        List<MoneyTransaction> actual = underTest.findAll();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        underTest.persist(testData);
        MoneyTransaction actual = underTest.findById(testData.getId());
        assertNotNull(actual);
        assertEquals(actual.getId(), testData.getId());
    }
}