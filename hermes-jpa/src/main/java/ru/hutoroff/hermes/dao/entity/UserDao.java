package ru.hutoroff.hermes.dao.entity;

import ru.hutoroff.hermes.dao.GenericDao;

import java.io.Serializable;

/**
 * Created by hutoroff on 22.08.16.
 */
public interface UserDao<User, Long extends Serializable> extends GenericDao<User, Long> {
}
