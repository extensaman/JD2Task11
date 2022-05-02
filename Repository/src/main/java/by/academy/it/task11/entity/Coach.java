package by.academy.it.task11.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table
public class Coach {
    public static final int SURNAME_LENGTH_LIMIT = 40;
    public static final int NAME_LENGTH_LIMIT = 30;
    public static final int PATRONYMIC_LENGTH_LIMIT = 35;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = SURNAME_LENGTH_LIMIT,nullable = false)
    private String surname;

    @Column(length = NAME_LENGTH_LIMIT,nullable = false)
    private String name;

    @Column(length = PATRONYMIC_LENGTH_LIMIT)
    private String patronymic;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "horse_join_coach", joinColumns = {@JoinColumn(name = "horse_id")},
    inverseJoinColumns = {@JoinColumn(name = "coach_id")})
    private Set<Horse> coachHorses;
}
