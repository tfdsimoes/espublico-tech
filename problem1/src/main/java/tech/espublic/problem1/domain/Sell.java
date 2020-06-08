package tech.espublic.problem1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Sell entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sell")
public class Sell implements Serializable {

    private static final long serialVersionUID = 779404188912113059L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "sales_channel")
    private String salesChannel;

    @Column(name = "order_priority")
    private String orderPriority;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "order_id")
    private Long orderID;

    @Column(name = "ship_date")
    private LocalDate shipDate;

    @Column(name = "units_sold")
    private Integer unitsSold;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "unit_cost")
    private Float unitCost;

    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "total_profit")
    private BigDecimal totalProfit;
}
