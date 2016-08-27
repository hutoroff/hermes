package ru.hutoroff.hermes.factory.impl.hibernate;

import org.hibernate.SessionFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HibernateUtilTest {

    @Test
    public void getSessionFactoryTest() throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        assertNotNull(sessionFactory);
        assertNotNull(sessionFactory.getCurrentSession());
    }
}