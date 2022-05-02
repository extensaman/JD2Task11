package by.academy.it.task11.dao.interf;

import java.util.List;

public interface EntityDao<T> {
    /**
     * @param id
     * @return -
     */
    T findById(Integer id);

    /**
     * @return -
     */
    List<T> findAll();

    /**
     * @param t
     */
    void save(T t);

    /**
     * @param list
     */
    void save(List<T> list);

    /**
     * @param t
     */
    void update(T t);

    /**
     * @param id
     */
    void delete(Integer id);

    void closeDao();
}
