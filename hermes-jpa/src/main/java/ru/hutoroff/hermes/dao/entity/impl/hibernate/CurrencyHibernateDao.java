package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.CurrencyDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.Currency;

/**
 * Currency DAO implemented for Hibernate
 * Created by hutoroff on 22.08.16.
 */
public class CurrencyHibernateDao extends GenericHibernateDao<Currency, Integer> implements CurrencyDao {
}
