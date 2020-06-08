package tech.espublic.problem1.mapper;

import org.junit.jupiter.api.Test;
import tech.espublic.problem1.domain.Sell;
import tech.espublic.problem1.file_processing.resource.SellResource;
import tech.espublic.problem1.util.BuilderDefaultObjects;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SellMapperTest {

    @Test
    void sellResourceToSell() {
        SellResource sellResource = BuilderDefaultObjects.sellResource();

        Sell sell = SellMapper.INSTANCE.sellResourceToSell(sellResource);

        compareSellResourceWithSell(sellResource, sell);
    }

    @Test
    void sellResourceListToSellList() {
        List<SellResource> sellResourceList = new ArrayList<>();
        sellResourceList.add(BuilderDefaultObjects.sellResource());
        sellResourceList.add(BuilderDefaultObjects.sellResource());
        sellResourceList.add(BuilderDefaultObjects.sellResource());
        sellResourceList.add(BuilderDefaultObjects.sellResource());

        List<Sell> sellList = SellMapper.INSTANCE.sellResourceListToSellList(sellResourceList);

        for (int i = 0; i < sellList.size(); i++) {
            compareSellResourceWithSell(sellResourceList.get(i), sellList.get(i));
        }
    }

    /**
     * Function that compares {@link SellResource} agains {@link Sell}
     * @param sellResource {@link SellResource} object
     * @param sell {@link Sell} object
     */
    private void compareSellResourceWithSell(SellResource sellResource, Sell sell) {
        assertNull(sell.getId());
        assertEquals(sell.getCountry(), sellResource.getCountry());
        assertEquals(sell.getItemType(), sellResource.getItemType());
        assertEquals(sell.getOrderDate(), sellResource.getOrderDate());
        assertEquals(sell.getOrderID(), sellResource.getOrderID());
        assertEquals(sell.getOrderPriority(), sellResource.getOrderPriority());
        assertEquals(sell.getRegion(), sellResource.getRegion());
        assertEquals(sell.getSalesChannel(), sellResource.getSalesChannel());
        assertEquals(sell.getShipDate(), sellResource.getShipDate());
        assertEquals(sell.getTotalCost(), sellResource.getTotalCost());
        assertEquals(sell.getTotalProfit(), sellResource.getTotalProfit());
        assertEquals(sell.getTotalRevenue(), sellResource.getTotalRevenue());
        assertEquals(sell.getUnitCost(), sellResource.getUnitCost());
        assertEquals(sell.getUnitPrice(), sellResource.getUnitPrice());
        assertEquals(sell.getUnitsSold(), sellResource.getUnitsSold());
    }

}
