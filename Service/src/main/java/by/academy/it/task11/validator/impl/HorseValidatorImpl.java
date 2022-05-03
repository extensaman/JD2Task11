package by.academy.it.task11.validator.impl;

import by.academy.it.task11.entity.Horse;
import by.academy.it.task11.entity.HorseDetail;
import by.academy.it.task11.validator.Validator;
import by.academy.it.task11.validator.ValidatorConstant;
import by.academy.it.task11.validator.ValidatorException;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;

public class HorseValidatorImpl implements Validator<Horse> {

    public static final String HORSE_S_NICKNAME = "Horse's nickname";
    public static final String HORSE_S_BREED = "Horse's breed";
    public static final String HORSE_S_SPECIALIZATION = "Horse's specialization";
    public static final String HORSE_S_SUIT = "Horse's suit";
    public static final String HORSE_S_PRICE = "Horse's price";
    public static final String HORSE_S_YEAR = "Horse's year of birth";
    public static final int HORSE_YEAR_OF_BIRTH_LIMIT = 1975;

    @Override
    public void validate(Horse entity) throws ValidatorException {
        Horse horse = Optional.ofNullable(entity)
                .orElseThrow(ValidatorException::new);
        boolean validationFail = false;
        StringBuilder builder = new StringBuilder();
        if (horse.getNickname().length() >
                Horse.HORSE_NICKNAME_LENGTH_LIMIT) {
            validationFail = true;
            builder.append(HORSE_S_NICKNAME)
                    .append(ValidatorConstant.LENGTH_MUST_BE_LESS_THEN)
                    .append(Horse.HORSE_NICKNAME_LENGTH_LIMIT)
                    .append(ValidatorConstant.SYMBOLS);
        }
        if(horse.getHorseDetail().getBreed().length() >
                HorseDetail.BREED_LENGTH_LIMIT) {
            validationFail = true;
            builder.append(HORSE_S_BREED)
                    .append(ValidatorConstant.LENGTH_MUST_BE_LESS_THEN)
                    .append(HorseDetail.BREED_LENGTH_LIMIT)
                    .append(ValidatorConstant.SYMBOLS);
        }
        if(horse.getHorseDetail().getSpecialization().length() >
                HorseDetail.SPECIALIZATION_LENGTH_LIMIT){
            validationFail = true;
            builder.append(HORSE_S_SPECIALIZATION)
                    .append(ValidatorConstant.LENGTH_MUST_BE_LESS_THEN)
                    .append(HorseDetail.SPECIALIZATION_LENGTH_LIMIT)
                    .append(ValidatorConstant.SYMBOLS);
        }
        if(horse.getHorseDetail().getSuit().length() >
                HorseDetail.SUIT_LENGTH_LIMIT){
            validationFail = true;
            builder.append(HORSE_S_SUIT)
                    .append(ValidatorConstant.LENGTH_MUST_BE_LESS_THEN)
                    .append(HorseDetail.SUIT_LENGTH_LIMIT)
                    .append(ValidatorConstant.SYMBOLS);
        }
        if(horse.getHorseDetail().getPrice().compareTo(BigDecimal.ZERO) < 0){
            validationFail = true;
            builder.append(HORSE_S_PRICE)
                    .append(ValidatorConstant.CANNOT_BE_NEGATIVE);
        }
        if(horse.getHorseDetail()
                .getDateOfBirth()
                .get(Calendar.YEAR) < HORSE_YEAR_OF_BIRTH_LIMIT){
            validationFail = true;
            builder.append(HORSE_S_YEAR)
                    .append(ValidatorConstant.CANNOT_BE_LESS_THEN)
            .append(HORSE_YEAR_OF_BIRTH_LIMIT);
        }
        if(validationFail) {
            throw new ValidatorException(builder.toString());
        }
    }
}
