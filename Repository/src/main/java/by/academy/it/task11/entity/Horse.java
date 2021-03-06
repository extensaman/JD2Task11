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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table
public class Horse {
    public static final int HORSE_NICKNAME_LENGTH_LIMIT = 100;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = HorseDetail.JOIN_COLUMN_NAME, unique = true)
    private Integer id;

    @Column(nullable = false,length = HORSE_NICKNAME_LENGTH_LIMIT)
    private String nickname;

    @OneToOne (mappedBy = "horseInDetail", cascade = CascadeType.ALL)
    private HorseDetail horseDetail;

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
