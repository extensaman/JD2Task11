package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.CoachDao;
import by.academy.it.task11.entity.Coach;

import javax.persistence.EntityManager;

public class CoachDaoImpl extends EntityDaoImpl<Coach> implements CoachDao {
    public CoachDaoImpl(EntityManager em) {
        super(em, Coach.class);
    }
}
