package by.academy.it.task11.validator;

import by.academy.it.task11.entity.Coach;
import by.academy.it.task11.entity.Horse;
import by.academy.it.task11.validator.impl.CoachValidatorImpl;
import by.academy.it.task11.validator.impl.HorseValidatorImpl;

public class ValidatorProvider {
    private static final ValidatorProvider INSTANCE = new ValidatorProvider();

    private ValidatorProvider() {
    }

    public static ValidatorProvider getInstance() {
        return INSTANCE;
    }

    public Validator<Horse> getHorseValidator() {
        return new HorseValidatorImpl();
    }

    public Validator<Coach> getCoachValidator() {
        return new CoachValidatorImpl();
    }
}
