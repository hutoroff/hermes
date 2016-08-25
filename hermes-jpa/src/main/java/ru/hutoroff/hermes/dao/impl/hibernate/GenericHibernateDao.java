package ru.hutoroff.hermes.dao.impl.hibernate;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import ru.hutoroff.hermes.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by hutoroff on 19.07.16.
 */
public abstract class GenericHibernateDao<T, Id extends Serializable> implements GenericDao<T, Id> {

    private Session session;
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericHibernateDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session was not set before usage");
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void persist(T entity) {
        Transaction transaction = getSession().beginTransaction();
        getSession().save(entity);
        transaction.commit();
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public T findById(Id id, boolean lock) {
        T entity;
        Transaction transaction = getSession().beginTransaction();
        if (lock)
            entity = getSession().load(getPersistentClass(), id, LockMode.UPGRADE_NOWAIT); //TODO: nowait?
        else
            entity = getSession().load(getPersistentClass(), id);
        transaction.commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @Override
    public T makePersitent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void makeTransient(T entity) {
        getSession().delete(entity);
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass()); //TODO: replace deprecated
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }
}
