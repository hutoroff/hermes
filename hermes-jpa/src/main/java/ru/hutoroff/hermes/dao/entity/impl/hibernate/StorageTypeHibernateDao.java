package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.StorageTypeDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;

import java.io.Serializable;

/**
 * Created by hutoroff on 22.08.16.
 */
public class StorageTypeHibernateDao<StorageType, Integer extends Serializable> extends GenericHibernateDao implements StorageTypeDao {
}
