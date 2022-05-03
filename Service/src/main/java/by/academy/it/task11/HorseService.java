package by.academy.it.task11;

import by.academy.it.task11.entity.Horse;
import by.academy.it.task11.validator.ValidatorException;

import java.util.List;
import java.util.Optional;

public interface HorseService {

    /**
     * @param id
     * @return -
     */
    Optional<Horse> findById(Integer id) throws ServiceException;

    List<Horse> findAll() throws ServiceException;

    /**
     * @param entity
     */
    void save(Horse entity) throws ServiceException, ValidatorException;

    /**
     * @param list
     */
    void save(List<Horse> list) throws ServiceException, ValidatorException;

    /**
     * @param entity
     */
    void update(Horse entity) throws ServiceException, ValidatorException;

    /**
     * @param id
     */
    void deleteById(final Integer id) throws ServiceException;

    /**
     * @param entity
     */
    void delete(final Horse entity) throws ServiceException;
}
