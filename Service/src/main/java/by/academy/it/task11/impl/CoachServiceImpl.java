package by.academy.it.task11.impl;

import by.academy.it.task11.CoachService;
import by.academy.it.task11.ServiceException;
import by.academy.it.task11.dao.DaoException;
import by.academy.it.task11.dao.DaoProvider;
import by.academy.it.task11.dao.interf.CoachDao;
import by.academy.it.task11.entity.Coach;
import by.academy.it.task11.validator.Validator;
import by.academy.it.task11.validator.ValidatorException;
import by.academy.it.task11.validator.ValidatorProvider;

import java.util.List;
import java.util.Optional;

public class CoachServiceImpl implements CoachService {
    @Override
    public Optional<Coach> findById(Integer id) throws ServiceException {
        Optional<Coach> optionalCoach;
        try (CoachDao coachDao = DaoProvider.getInstance().getCoachDao()) {
            optionalCoach = coachDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return optionalCoach;
    }

    @Override
    public List<Coach> findAll() throws ServiceException {
        List<Coach> all;
        try (CoachDao coachDao = DaoProvider.getInstance().getCoachDao()) {
            all = coachDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return all;
    }

    @Override
    public void save(Coach entity) throws ServiceException, ValidatorException {

        ValidatorProvider.getInstance()
                .getCoachValidator()
                .validate(entity);

        try (CoachDao coachDao = DaoProvider.getInstance().getCoachDao()) {
            coachDao.save(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(List<Coach> list)
            throws ServiceException, ValidatorException {
        Validator<Coach> coachValidator = ValidatorProvider
                .getInstance()
                .getCoachValidator();
        for (Coach coach : list) {
            coachValidator.validate(coach);
        }
        try (CoachDao coachDao = DaoProvider.getInstance().getCoachDao()) {
            coachDao.save(list);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Coach entity) throws ServiceException, ValidatorException {

        ValidatorProvider.getInstance()
                .getCoachValidator()
                .validate(entity);

        try (CoachDao coachDao = DaoProvider.getInstance().getCoachDao()) {
            coachDao.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {

    }

    @Override
    public void delete(Coach entity) throws ServiceException {

    }
}
