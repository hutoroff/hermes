package ru.hutoroff.hermes.hibernate.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by hutoroff on 17.07.16.
 */
public class SessionFactoryProvider {

    private static SessionFactory instance;

    public static SessionFactory getInstance() {
        if(instance == null) {
            Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
            instance = configuration.buildSessionFactory();
        }
        return instance;
    }
}
