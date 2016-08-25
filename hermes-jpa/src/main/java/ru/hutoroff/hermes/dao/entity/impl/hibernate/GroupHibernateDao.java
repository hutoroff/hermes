package ru.hutoroff.hermes.dao.entity.impl.hibernate;

import ru.hutoroff.hermes.dao.entity.GroupDao;
import ru.hutoroff.hermes.dao.impl.hibernate.GenericHibernateDao;
import ru.hutoroff.hermes.model.Group;

/**
 * Created by hutoroff on 22.08.16.
 */
public class GroupHibernateDao extends GenericHibernateDao<Group, Long> implements GroupDao {
}
