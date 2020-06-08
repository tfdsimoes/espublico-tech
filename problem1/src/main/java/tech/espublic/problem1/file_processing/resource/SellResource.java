package tech.espublic.problem1.file_processing.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class that represent the sell from csv
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellResource {
    private String region;

    private String country;

    private String itemType;

    private String salesChannel;

    private String orderPriority;

    private LocalDate orderDate;

    private Long orderID;

    private LocalDate shipDate;

    private Integer unitsSold;

    private Float unitPrice;

    private Float unitCost;

    private BigDecimal totalRevenue;

    private BigDecimal totalCost;

    private BigDecimal totalProfit;

    /**
     * Function that will handle the conversion of object to csv line
     *
     * @return String of csv
     */
    public String sellResourceToCSVLine() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        return this.region + "," + this.country + "," + this.itemType  + "," + this.salesChannel  + "," + this.orderPriority
                + "," + this.orderDate.format(formatter)  + "," + this.orderID  + "," + this.shipDate.format(formatter)
                + "," + this.unitsSold  + "," + this.unitPrice + "," + this.unitCost  + "," + this.totalRevenue
                + "," + this.totalCost  + "," + this.totalProfit;
    }
}
