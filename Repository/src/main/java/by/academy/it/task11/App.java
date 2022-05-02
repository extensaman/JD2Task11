package by.academy.it.task11;

import by.academy.it.task11.dao.DaoFactory;
import by.academy.it.task11.dao.interf.HorseDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HorseDao horseDao = DaoFactory.getInstance().getHorseDao();
        System.out.println(horseDao.findAll());
/*        System.out.println( "Start!" );
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");
        EntityManager entityManager = factory.createEntityManager();
        StudyAndRentActivity activity = entityManager.find(StudyAndRentActivity.class, 1);
        System.out.println(activity);
        Horse horse = entityManager.find(Horse.class, 1);
        activity.getHorses().remove(horse);
        entityManager.getTransaction().begin();
        entityManager.merge(activity);
        entityManager.getTransaction().commit();
        System.out.println(activity);
        entityManager.close();*/
    }
}
