package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.StorageDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.Storage;

/**
 * Storage DAO implemented for Hibernate
 * Created by hutoroff on 22.08.16.
 */
public class StorageHibernateDao extends GenericHibernateDao<Storage, Long> implements StorageDao {
}
