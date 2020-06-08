package tech.espublic.problem1.util;

import tech.espublic.problem1.file_processing.resource.SellResource;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Class that handles the creation of default objects
 */
public class BuilderDefaultObjects {

    /**
     * Function that build {@link SellResource} default
     *
     * @return {@link SellResource}
     */
    public static SellResource sellResource() {
        return SellResource.builder()
                .totalProfit(BigDecimal.TEN)
                .totalCost(BigDecimal.TEN)
                .totalRevenue(BigDecimal.TEN)
                .unitCost(1.0F)
                .unitPrice(1.0F)
                .unitsSold(1)
                .shipDate(LocalDate.now())
                .orderID(1L)
                .orderDate(LocalDate.now())
                .orderPriority("orderPriority")
                .salesChannel("salesChannel")
                .itemType("itemType")
                .country("country")
                .region("region")
                .build();
    }
}
