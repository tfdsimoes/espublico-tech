package tech.espublic.problem1.file_processing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.espublic.problem1.file_processing.resource.SellResource;
import tech.espublic.problem1.file_processing.util.ConvertCSVFileToSellResourceList;
import tech.espublic.problem1.file_processing.util.QuickSort;
import tech.espublic.problem1.file_processing.util.SaveSellResourceListToCSV;
import tech.espublic.problem1.mapper.SellMapper;
import tech.espublic.problem1.repository.SellRepository;

import java.util.List;

/**
 * Class that handle all the file processing
 */
@Component
@Slf4j
public class FileProcessor {

    private final ConvertCSVFileToSellResourceList convertCSVFileToSellResourceList;

    private final QuickSort quickSort;

    private final SaveSellResourceListToCSV saveSellResourceListToCSV;

    private final SellRepository sellRepository;

    public FileProcessor(ConvertCSVFileToSellResourceList convertCSVFileToSellResourceList, QuickSort quickSort, SaveSellResourceListToCSV saveSellResourceListToCSV, SellRepository sellRepository) {
        this.convertCSVFileToSellResourceList = convertCSVFileToSellResourceList;
        this.quickSort = quickSort;
        this.saveSellResourceListToCSV = saveSellResourceListToCSV;
        this.sellRepository = sellRepository;
    }

    /**
     * Function that will launch the process of compile the file
     *
     * @param path path to the file
     */
    public void processFile(String path) {
        log.info("Starting processing of CSV");
        List<SellResource> sellResourceList = convertCSVFileToSellResourceList.processFile(path);

        log.info("Sorting the list of {}", sellResourceList.size());
        quickSort.quickSortAlgorithm(sellResourceList, 0, sellResourceList.size() - 1);

        log.info("Writing file order by Order Id");
        saveSellResourceListToCSV.writeToCSV(path, sellResourceList);

        log.info("Save to DB the sells");
        sellRepository.saveAll(SellMapper.INSTANCE.sellResourceListToSellList(sellResourceList));
    }
}
