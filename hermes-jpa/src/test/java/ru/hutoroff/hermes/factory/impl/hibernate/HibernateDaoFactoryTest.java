package ru.hutoroff.hermes.factory.impl.hibernate;

import org.junit.Test;
import ru.hutoroff.hermes.dao.entity.GroupDao;
import ru.hutoroff.hermes.factory.DaoFactory;
import ru.hutoroff.hermes.model.Group;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by hutoroff on 23.08.16.
 */
public class HibernateDaoFactoryTest {

    /*@Test
    public void testGetAccountDao() throws Exception {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.HIBERNATE);
        AccountDao accountDao = daoFactory.getAccountDao();
    }*/

    @Test
    public void testGetGroupDao() throws Exception {
        DaoFactory daoFactory = DaoFactory.getInstance();
        GroupDao groupDao = daoFactory.getGroupDao();

        Group testGroup = new Group();
        testGroup.setId(1l);
        testGroup.setName("Test Group");
        testGroup.setCreateDate(new Date());

        groupDao.persist(testGroup);
        Group foundGroup = groupDao.findById(testGroup.getId(), false);
        assertEquals(testGroup.getName(), foundGroup.getName());
    }

}