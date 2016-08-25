package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.CurrencyDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;

import java.io.Serializable;

/**
 * Created by hutoroff on 22.08.16.
 */
public class CurrencyHibernateDao<Currency, Integer extends Serializable> extends GenericHibernateDao implements CurrencyDao {
}
