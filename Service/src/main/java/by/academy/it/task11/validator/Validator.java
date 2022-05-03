package by.academy.it.task11.validator;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
