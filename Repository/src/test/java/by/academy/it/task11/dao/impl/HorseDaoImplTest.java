package by.academy.it.task11.dao.impl;

import by.academy.it.task11.MockConstant;
import by.academy.it.task11.MockUtil;
import by.academy.it.task11.dao.DaoProvider;
import by.academy.it.task11.dao.DaoException;
import by.academy.it.task11.dao.interf.HorseDao;
import by.academy.it.task11.entity.Horse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class HorseDaoImplTest extends Assertions {

    @Test
    void findAll() {
    }

    @Test
    void shouldSaveHorse01ThenFindIt() throws DaoException {
        Horse horse01 = MockUtil.getHorse01();
        try(HorseDao horseDao = DaoProvider.getInstance().getHorseDao()){
            horseDao.save(horse01);
        }
        Integer horse01Id = horse01.getId();
        try(HorseDao horseDao = DaoProvider.getInstance().getHorseDao()){
            Optional<Horse> optionalHorse01 = horseDao.findById(horse01Id);

            optionalHorse01.ifPresentOrElse(horse -> {
                assertEquals(MockConstant.HORSE01_NICKNAME,horse.getNickname());
                assertEquals(MockConstant.HORSE01_BREED,
                        horse.getHorseDetail().getBreed());
                assertEquals(MockConstant.HORSE01_SUIT,
                        horse.getHorseDetail().getSuit());
                assertEquals(MockConstant.HORSE01_SPECIALIZATION,
                        horse.getHorseDetail().getSpecialization());
                assertEquals(MockConstant.HORSE01_PRICE,
                        horse.getHorseDetail().getPrice());
                assertEquals(MockConstant.HORSE01_DATE_OF_BIRTH,
                        horse.getHorseDetail().getDateOfBirth());
            }, Assertions::fail);
        }
    }

    @Test
    void shouldSaveHorse01ThenDeleteItThenNotFindIt() throws DaoException {
        Horse horse01 = MockUtil.getHorse01();
        try(HorseDao horseDao = DaoProvider.getInstance().getHorseDao()){
            horseDao.save(horse01);
        }
        Integer horse01Id = horse01.getId();
        try(HorseDao horseDao = DaoProvider.getInstance().getHorseDao()){
            horseDao.deleteById(horse01Id);
        }
        try(HorseDao horseDao = DaoProvider.getInstance().getHorseDao()){
            Optional<Horse> optionalHorse01 = horseDao.findById(horse01Id);
            optionalHorse01.ifPresent(horse -> fail());
        }
    }

    @Test
    void update() {
    }
}