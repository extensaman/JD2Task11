package by.academy.it.task11.impl;

import by.academy.it.task11.HorseService;
import by.academy.it.task11.dao.DaoFactory;
import by.academy.it.task11.dao.interf.HorseDao;
import by.academy.it.task11.entity.Horse;

import java.util.List;

public class HorseServiceImpl implements HorseService {
    @Override
    public List<Horse> findAll() {
        HorseDao horseDao = DaoFactory.getInstance().getHorseDao();
        List<Horse> all = horseDao.findAll();
        horseDao.closeDao();
        return all;
    }
}
