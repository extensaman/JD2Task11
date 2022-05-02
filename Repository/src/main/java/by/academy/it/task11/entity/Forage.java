package by.academy.it.task11.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table
public class Forage {
    public static final String AMOUNT_COLUMN_DEFINITION = "Decimal(10,2) default '0.00'";
    public static final String PRICE_COLUMN_DEFINITION = "Decimal(10,2) default '0.00'";
    public static final String CROP_YEAR_COLUMN_NAME = "crop_year";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String kind;

    @Column(name = CROP_YEAR_COLUMN_NAME)
    private Integer cropYear;

    @Column(columnDefinition = AMOUNT_COLUMN_DEFINITION)
    private BigDecimal amount;

    @Column(columnDefinition = PRICE_COLUMN_DEFINITION)
    private BigDecimal price;
}
