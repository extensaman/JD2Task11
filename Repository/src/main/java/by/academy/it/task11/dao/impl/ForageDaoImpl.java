package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.ForageDao;
import by.academy.it.task11.entity.Forage;

import javax.persistence.EntityManager;

public class ForageDaoImpl extends EntityDaoImpl<Forage> implements ForageDao {
    public ForageDaoImpl(EntityManager em) {
        super(em, Forage.class);
    }
}
