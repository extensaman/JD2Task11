package by.academy.it.task11.dao;

import by.academy.it.task11.dao.impl.HorseDaoImpl;
import by.academy.it.task11.dao.interf.HorseDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {
    public static final String PERSISTENCE_UNIT_NAME = "lopata";
    private final static DaoFactory INSTANCE =
            new DaoFactory();
    private final EntityManagerFactory factory;

   /* private static class SingletonHolder {
        private final static DaoFactory INSTANCE =
                new DaoFactory();
    }*/

    private DaoFactory() {
        factory = Persistence
                .createEntityManagerFactory(
                        PERSISTENCE_UNIT_NAME);
    }

    /**
     * @return -
     */
    public static DaoFactory getInstance() {

        //return SingletonHolder.INSTANCE;
        return INSTANCE;
    }

    public HorseDao getHorseDao(){
        return new HorseDaoImpl(factory.createEntityManager());
    }
}
