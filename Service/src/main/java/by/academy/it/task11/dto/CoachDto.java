package by.academy.it.task11.dto;

import by.academy.it.task11.entity.Coach;

public class CoachDto {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private int horseCount;

    public CoachDto(Coach coach) {
        this.id = coach.getId();
        this.surname = coach.getSurname();
        this.name = coach.getName();
        this.patronymic = coach.getPatronymic();
        this.horseCount = coach.getCoachHorses().size();
    }
}
