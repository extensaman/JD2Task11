package by.academy.it.task11.dao.impl;

import by.academy.it.task11.dao.interf.EntityDao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EntityDaoImpl<T> implements EntityDao<T> {
    /**
     *
     */
    protected final EntityManager entityManager;
    /**
     *
     */
    private final Class<T> aClass;

    /**
     * @param em
     * @param a
     */
    public EntityDaoImpl(final EntityManager em,
                         final Class<T> a) {
        this.entityManager = em;
        this.aClass = a;
    }

    @Override
    public T findById(Integer id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> rootEntry = criteriaQuery.from(aClass);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public void save(T t) {

    }

    @Override
    public void save(List<T> list) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void closeDao() {
        entityManager.close();
    }
}
