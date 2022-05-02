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
@Table
public class Transport {
    public static final int TRANSPORT_DESCRIPTION_LENGTH_LIMIT = 200;
    public static final String PRICE_COLUMN_DEFINITION = "Decimal(10,2) default '0.00'";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = TRANSPORT_DESCRIPTION_LENGTH_LIMIT)
    private String description;

    @Column(name = "delivery_price", columnDefinition = PRICE_COLUMN_DEFINITION)
    private BigDecimal deliveryPrice;

    @ManyToMany(mappedBy = "transportSet", cascade = CascadeType.ALL)
    private Set<DeliveryActivity> deliveryActivities;
}
