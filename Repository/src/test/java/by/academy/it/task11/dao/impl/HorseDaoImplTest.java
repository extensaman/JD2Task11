package by.academy.it.task11.dao.impl;

import by.academy.it.task11.MockConstant;
import by.academy.it.task11.MockUtil;
import by.academy.it.task11.dao.DaoFactory;
import by.academy.it.task11.dao.EntityDaoException;
import by.academy.it.task11.dao.interf.HorseDao;
import by.academy.it.task11.entity.Horse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HorseDaoImplTest extends Assertions {

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void shouldSaveHorse01AndFindIt() throws EntityDaoException {
        HorseDao horseDao = DaoFactory.getInstance().getHorseDao();
        Horse horse01 = MockUtil.getHorse01();
        horseDao.save(horse01);
        horseDao.closeDao();
        HorseDao newHorseDao = DaoFactory.getInstance().getHorseDao();
        Integer horse01Id = horse01.getId();
        Optional<Horse> optionalHorse01 = newHorseDao.findById(horse01Id);
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
        newHorseDao.closeDao();
    }

    @Test
    void testSave() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void closeDao() {
    }
}