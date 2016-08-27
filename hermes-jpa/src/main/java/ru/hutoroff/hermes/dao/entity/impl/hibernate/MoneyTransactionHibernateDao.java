package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.MoneyTransactionDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.MoneyTransaction;

/**
 * DAO implemented for Hibernate
 * Created by hutoroff on 22.08.16.
 */
public class MoneyTransactionHibernateDao extends GenericHibernateDao<MoneyTransaction, Long> implements MoneyTransactionDao {
}
