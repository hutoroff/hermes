package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.StorageTypeDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.StorageType;

/**
 * DAO implemented for Hibernate
 * Created by hutoroff on 22.08.16.
 */
public class StorageTypeHibernateDao extends GenericHibernateDao<StorageType, Integer> implements StorageTypeDao {
}
