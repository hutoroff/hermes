package ru.hutoroff.hermes.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.hutoroff.hermes.hibernate.jpa.SessionFactoryProvider;
import ru.hutoroff.hermes.hibernate.exception.DataBaseException;

/**
 * Created by hutoroff on 16.07.16.
 */
public abstract class SessionService {

    protected Session session;
    private Transaction transaction;

    public Session openSessionWithTransaction() {
        createTransaction();
        return session;
    }

    public void closeSessionWithTransaction() throws DataBaseException {
        finishTransaction();
        closeSession();
    }

    private Session openSession() {
        session = getSessionFactory().openSession();
        return session;
    }

    private void closeSession() {
        if(session != null) {
            session.close();
            session = null;
        }
    }

    private Transaction createTransaction() {
        if(session == null)
            session = openSession();
        if(transaction == null)
            transaction = session.beginTransaction();

        return transaction;
    }

    private void finishTransaction() throws DataBaseException {
        if(transaction != null) {
            try {
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw new DataBaseException("Exception on transaction commit. ", e);
            }
            transaction = null;
        }
    }

    private static SessionFactory getSessionFactory() {
        return SessionFactoryProvider.getInstance();
    }
}
