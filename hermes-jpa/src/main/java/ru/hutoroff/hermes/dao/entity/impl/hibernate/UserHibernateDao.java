package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.UserDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.User;

/**
 * User DAO implemented for Hibernate
 * Created by hutoroff on 22.08.16.
 */
public class UserHibernateDao extends GenericHibernateDao<User, Long> implements UserDao {
}
