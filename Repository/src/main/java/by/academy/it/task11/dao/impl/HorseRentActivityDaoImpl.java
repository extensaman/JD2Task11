package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.HorseRentActivityDao;
import by.academy.it.task11.entity.HorseRentActivity;

import javax.persistence.EntityManager;

public class HorseRentActivityDaoImpl
        extends EntityDaoImpl<HorseRentActivity>
        implements HorseRentActivityDao {
    public HorseRentActivityDaoImpl(EntityManager em) {
        super(em, HorseRentActivity.class);
    }
}
