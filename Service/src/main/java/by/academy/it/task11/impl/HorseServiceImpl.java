package by.academy.it.task11.impl;

import by.academy.it.task11.HorseService;
import by.academy.it.task11.ServiceException;
import by.academy.it.task11.dao.DaoException;
import by.academy.it.task11.dao.DaoProvider;
import by.academy.it.task11.dao.interf.HorseDao;
import by.academy.it.task11.entity.Horse;
import by.academy.it.task11.validator.Validator;
import by.academy.it.task11.validator.ValidatorException;
import by.academy.it.task11.validator.ValidatorProvider;

import java.util.List;
import java.util.Optional;

public class HorseServiceImpl implements HorseService {

    @Override
    public Optional<Horse> findById(Integer id) throws ServiceException {
        Optional<Horse> optionalHorse;
        try (HorseDao horseDao = DaoProvider.getInstance().getHorseDao()) {
            optionalHorse = horseDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return optionalHorse;
    }

    @Override
    public List<Horse> findAll() throws ServiceException {
        List<Horse> all;
        try (HorseDao horseDao = DaoProvider.getInstance().getHorseDao()) {
            all = horseDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return all;
    }

    @Override
    public void save(Horse entity) throws ServiceException, ValidatorException {

        ValidatorProvider.getInstance()
                .getHorseValidator()
                .validate(entity);

        try (HorseDao horseDao = DaoProvider.getInstance().getHorseDao()) {
            horseDao.save(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(List<Horse> list)
            throws ServiceException, ValidatorException {
        Validator<Horse> horseValidator = ValidatorProvider
                .getInstance()
                .getHorseValidator();
        for (Horse horse : list) {
            horseValidator.validate(horse);
        }
        try (HorseDao horseDao = DaoProvider.getInstance().getHorseDao()) {
            horseDao.save(list);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Horse entity) throws ServiceException, ValidatorException {

        ValidatorProvider.getInstance()
                .getHorseValidator()
                .validate(entity);

        try (HorseDao horseDao = DaoProvider.getInstance().getHorseDao()) {
            horseDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {

    }

    @Override
    public void delete(Horse entity) throws ServiceException {

    }
}
