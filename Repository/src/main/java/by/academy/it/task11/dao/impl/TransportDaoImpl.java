package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.TransportDao;
import by.academy.it.task11.entity.Transport;

import javax.persistence.EntityManager;

public class TransportDaoImpl
        extends EntityDaoImpl<Transport>
        implements TransportDao {
    public TransportDaoImpl(EntityManager em) {
        super(em, Transport.class);
    }
}
