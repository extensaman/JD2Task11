package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.HorseDao;
import by.academy.it.task11.entity.Horse;

import javax.persistence.EntityManager;

public class HorseDaoImpl extends EntityDaoImpl<Horse> implements HorseDao {
    public HorseDaoImpl(EntityManager em) {
        super(em, Horse.class);
    }
}
