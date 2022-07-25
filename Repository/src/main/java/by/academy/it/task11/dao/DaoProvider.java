package by.academy.it.task11.dao;

import by.academy.it.task11.dao.impl.CoachDaoImpl;
import by.academy.it.task11.dao.impl.DeliveryActivityDaoImpl;
import by.academy.it.task11.dao.impl.ForageDaoImpl;
import by.academy.it.task11.dao.impl.HorseDaoImpl;
import by.academy.it.task11.dao.impl.HorseRentActivityDaoImpl;
import by.academy.it.task11.dao.impl.TransportDaoImpl;
import by.academy.it.task11.dao.interf.CoachDao;
import by.academy.it.task11.dao.interf.DeliveryActivityDao;
import by.academy.it.task11.dao.interf.ForageDao;
import by.academy.it.task11.dao.interf.HorseDao;
import by.academy.it.task11.dao.interf.HorseRentActivityDao;
import by.academy.it.task11.dao.interf.TransportDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoProvider {
    public static final String PERSISTENCE_UNIT_NAME = "lopata";
    private final static DaoProvider INSTANCE =
            new DaoProvider();
    private final EntityManagerFactory factory;

    private static class SingletonHolder {
        private final static DaoProvider INSTANCE =
                new DaoProvider();
    }

    private DaoProvider() {
        factory = Persistence
                .createEntityManagerFactory(
                        PERSISTENCE_UNIT_NAME);
    }

    /**
     * @return -
     */
    public static DaoProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public HorseDao getHorseDao() {
        return new HorseDaoImpl(factory.createEntityManager());
    }

    public TransportDao getTransportDao() {
        return new TransportDaoImpl(factory.createEntityManager());
    }

    public HorseRentActivityDao getHorseRentActivityDao() {
        return new HorseRentActivityDaoImpl(factory.createEntityManager());
    }

    public ForageDao getForageDao() {
        return new ForageDaoImpl(factory.createEntityManager());
    }

    public DeliveryActivityDao getDeliveryActivityDao() {
        return new DeliveryActivityDaoImpl(factory.createEntityManager());
    }

    public CoachDao getCoachDao() {
        return new CoachDaoImpl(factory.createEntityManager());
    }
}
