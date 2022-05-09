package by.academy.it.task11;

import by.academy.it.task11.entity.Coach;
import by.academy.it.task11.validator.ValidatorException;

import java.util.List;
import java.util.Optional;

public interface CoachService {
    /**
     * @param id
     * @return -
     */
    Optional<Coach> findById(Integer id) throws ServiceException;

    List<Coach> findAll() throws ServiceException;

    /**
     * @param entity
     */
    void save(Coach entity) throws ServiceException, ValidatorException;

    /**
     * @param list
     */
    void save(List<Coach> list) throws ServiceException, ValidatorException;

    /**
     * @param entity
     */
    void update(Coach entity) throws ServiceException, ValidatorException;

    /**
     * @param id
     */
    void deleteById(final Integer id) throws ServiceException;

    /**
     * @param entity
     */
    void delete(final Coach entity) throws ServiceException;
}
