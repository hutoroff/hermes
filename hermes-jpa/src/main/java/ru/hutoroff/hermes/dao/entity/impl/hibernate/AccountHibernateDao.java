package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.AccountDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.Account;

/**
 * Account DAO implemented for Hibernate
 * Created by hutoroff on 22.08.16.
 */
public class AccountHibernateDao extends GenericHibernateDao<Account, Long> implements AccountDao {
}
