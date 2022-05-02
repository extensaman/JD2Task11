package by.academy.it.task11.dao.interf;

import by.academy.it.task11.dao.EntityDaoException;

import java.util.List;
import java.util.Optional;

public interface EntityDao<T> {
    /**
     * @param id
     * @return -
     */
    Optional<T> findById(Integer id) throws EntityDaoException;

    /**
     * @return -
     */
    List<T> findAll();

    /**
     * @param t
     */
    void save(T t) throws EntityDaoException;

    /**
     * @param list
     */
    void save(List<T> list) throws EntityDaoException;

    /**
     * @param entity
     */
    void update(T entity) throws EntityDaoException;

    /**
     * @param id
     */
    void deleteById(final Integer id) throws EntityDaoException;

    /**
     * @param entity
     */
    void delete(final T entity) throws EntityDaoException;


    void closeDao();
}
