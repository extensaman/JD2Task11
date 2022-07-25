package by.academy.it.task11.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "horse_detail")
public class HorseDetail {
    public static final int BREED_LENGTH_LIMIT = 40;
    public static final int SUIT_LENGTH_LIMIT = 40;
    public static final int SPECIALIZATION_LENGTH_LIMIT = 40;
    public static final String PRICE_COLUMN_DEFINITION = "Decimal(10,2) default '0.00'";
    public static final String JOIN_COLUMN_NAME = "h_id";
    public static final String DATE_OF_BIRTH_COLUMN_NAME = "date_of_birth";
    @Id
    @GenericGenerator(name = "one-one",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "horseInDetail"))
    @GeneratedValue(generator = "one-one")
    @Column(name = JOIN_COLUMN_NAME)
    private Integer id;

    @Column(length = BREED_LENGTH_LIMIT, nullable = false)
    private String breed;

    @Column(length = SUIT_LENGTH_LIMIT, nullable = false)
    private String suit;

    @Column(length = SPECIALIZATION_LENGTH_LIMIT)
    private String specialization;

    @Column(name = DATE_OF_BIRTH_COLUMN_NAME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar dateOfBirth;

    @Column(columnDefinition = PRICE_COLUMN_DEFINITION)
    private BigDecimal price;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Horse horseInDetail;
}
