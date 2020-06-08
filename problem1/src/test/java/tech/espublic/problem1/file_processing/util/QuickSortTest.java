package tech.espublic.problem1.file_processing.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.espublic.problem1.file_processing.resource.SellResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class that test the quick sort
 */
public class QuickSortTest {

    private QuickSort quickSort;

    @BeforeEach
    public void setUp() throws Exception {
        this.quickSort = new QuickSort();
    }

    @Test
    public void quickSortAlgorithm() {
        List<SellResource> sellResourceListOrder = buildOrderListSellResource();
        List<SellResource> sellResourceListRandom = buildOrderListSellResource();
        Collections.shuffle(sellResourceListRandom);

        quickSort.quickSortAlgorithm(sellResourceListRandom, 0, sellResourceListRandom.size() - 1);

        for (int i = 0; i < sellResourceListOrder.size(); i++) {
            assertEquals(sellResourceListOrder.get(i).getOrderID(), sellResourceListRandom.get(i).getOrderID());
        }

    }

    /**
     * Aux function that create an list {@link SellResource} order
     *
     * @return List {@link SellResource}
     */
    private List<SellResource> buildOrderListSellResource() {
        List<SellResource> orderSellResourceList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            orderSellResourceList.add(SellResource.builder().orderID((long) i).build());
        }

        return orderSellResourceList;
    }
}
