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
import java.math.BigDecimal;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = StudyAndRentActivity.SAR_ACTIVITY_TABLE_NAME)
public class StudyAndRentActivity {
    public static final int SAR_ACTIVITY_DESCRIPTION_LENGTH_LIMIT = 1000;
    public static final String SAR_ACTIVITY_TABLE_NAME = "study_and_rent_activity";
    public static final String SAR_ACTIVITY_AND_HORSE_JOIN_TABLE_NAME = "horse_join_sar_activity";
    public static final String HORSE_JOIN_COLUMN_NAME = "horse_id";
    public static final String INVERSE_SAR_ACTIVITY_JOIN_COLUMN_NAME = "sar_activity_id";
    public static final String RENT_PRICE_COLUMN_DEFINITION = "Decimal(10,2) default '0.00'";
    public static final String RENT_PRICE_COLUMN_NAME = "rent_price";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = SAR_ACTIVITY_DESCRIPTION_LENGTH_LIMIT)
    private String description;

    @Column(name = RENT_PRICE_COLUMN_NAME, columnDefinition = RENT_PRICE_COLUMN_DEFINITION)
    private BigDecimal rentPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = SAR_ACTIVITY_AND_HORSE_JOIN_TABLE_NAME, joinColumns = {@JoinColumn(name = HORSE_JOIN_COLUMN_NAME)},
    inverseJoinColumns = {@JoinColumn(name = INVERSE_SAR_ACTIVITY_JOIN_COLUMN_NAME)})
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
