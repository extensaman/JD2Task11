package by.academy.it.task11;

import by.academy.it.task11.entity.Horse;
import by.academy.it.task11.entity.HorseDetail;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MockUtil {

    public static Horse getHorse01() {
        Horse horse01 = Horse.builder()
                .nickname(MockConstant.HORSE01_NICKNAME)
                .build();
        HorseDetail horse01Detail = HorseDetail.builder()
                .breed(MockConstant.HORSE01_BREED)
                .suit(MockConstant.HORSE01_SUIT)
                .specialization(MockConstant.HORSE01_SPECIALIZATION)
                .dateOfBirth(MockConstant.HORSE01_DATE_OF_BIRTH)
                .price(MockConstant.HORSE01_PRICE)
                .horseInDetail(horse01)
                .build();
        horse01.setHorseDetail(horse01Detail);
        return horse01;
    }
}
