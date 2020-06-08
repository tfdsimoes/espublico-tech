package tech.espublic.problem1.file_processing.util;

import org.springframework.stereotype.Component;
import tech.espublic.problem1.file_processing.resource.SellResource;

import java.util.List;

/**
 * Class that will handle the order the list
 */
@Component
public class QuickSort {

    /**
     * Method that breaks the list into small pieces to be sorted
     *
     * @param sellResourceList List to be sorted
     * @param begin            first position element
     * @param end              last position element
     */
    public void quickSortAlgorithm(List<SellResource> sellResourceList, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(sellResourceList, begin, end);

            quickSortAlgorithm(sellResourceList, begin, partitionIndex - 1);
            quickSortAlgorithm(sellResourceList, partitionIndex + 1, end);
        }
    }

    /**
     * Set all the elements with less value to the left of the pivot and on the right the bigger
     *
     * @param sellResourceList List to be sorted
     * @param begin            first position element
     * @param end              last position element
     * @return List {@link SellResource}
     */
    private int partition(List<SellResource> sellResourceList, int begin, int end) {
        Long pivot = sellResourceList.get(end).getOrderID();
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (sellResourceList.get(j).getOrderID() <= pivot) {
                i++;

                SellResource swapTemp = sellResourceList.get(i);
                sellResourceList.set(i, sellResourceList.get(j));
                sellResourceList.set(j, swapTemp);

            }
        }

        SellResource swapTemp = sellResourceList.get(i + 1);
        sellResourceList.set(i + 1, sellResourceList.get(end));
        sellResourceList.set(end, swapTemp);

        return i + 1;
    }
}
