package by.academy.it.task11;

import by.academy.it.task11.dao.DaoException;
import by.academy.it.task11.dao.DaoProvider;
import by.academy.it.task11.dao.interf.HorseDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(HorseDao horseDao = DaoProvider.getInstance().getHorseDao()){
            System.out.println(horseDao.findAll());
        } catch (DaoException e) {

        }
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
