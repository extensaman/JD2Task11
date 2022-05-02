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
@Table (name = "delivery_activity")
public class DeliveryActivity {
    public static final int DELIVERY_ACTIVITY_DESCRIPTION_LENGTH_LIMIT = 300;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = DELIVERY_ACTIVITY_DESCRIPTION_LENGTH_LIMIT)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transport_join_delivery", joinColumns = {@JoinColumn(name = "transport_id")},
            inverseJoinColumns = {@JoinColumn(name = "delivery_id")})
    private Set<Transport> transportSet;


}
