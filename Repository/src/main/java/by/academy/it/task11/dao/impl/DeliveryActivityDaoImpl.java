package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.DeliveryActivityDao;
import by.academy.it.task11.entity.DeliveryActivity;

import javax.persistence.EntityManager;

public class DeliveryActivityDaoImpl
        extends EntityDaoImpl<DeliveryActivity>
        implements DeliveryActivityDao {

    public DeliveryActivityDaoImpl(EntityManager em) {
        super(em, DeliveryActivity.class);
    }
}
