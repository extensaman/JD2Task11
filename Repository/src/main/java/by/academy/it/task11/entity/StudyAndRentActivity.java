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
@Table(name = "study_and_rent_activity")
public class StudyAndRentActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1000)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "horse_sar_activity", joinColumns = {@JoinColumn(name = "horse_id")},
    inverseJoinColumns = {@JoinColumn(name = "sar_activity_id")})
    private Set<Horse> horses;

    @Override
    public String toString() {
        return "StudyAndRentActivity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", horses=" + horses +
                '}';
    }
}
