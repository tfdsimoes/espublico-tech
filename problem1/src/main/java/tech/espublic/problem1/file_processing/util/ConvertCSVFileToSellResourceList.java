package tech.espublic.problem1.file_processing.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.espublic.problem1.file_processing.resource.SellResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class that handles the read of csv and conversion
 */
@Component
@Slf4j
public class ConvertCSVFileToSellResourceList {

    /**
     * Mapper that converts line of CSV to POJO
     */
    private final Function<String, SellResource> mapToSellResource = (line) -> {
        String[] values = line.split(",");

        return SellResource.builder()
                .region(values[0])
                .country(values[1])
                .itemType(values[2])
                .salesChannel(values[3])
                .orderPriority(values[4])
                .orderDate(convertStringToLocalDate(values[5]))
                .orderID(Long.parseLong(values[6]))
                .shipDate(convertStringToLocalDate(values[7]))
                .unitsSold(Integer.valueOf(values[8]))
                .unitPrice(Float.valueOf(values[9]))
                .unitCost(Float.valueOf(values[10]))
                .totalRevenue(new BigDecimal(values[11]))
                .totalCost(new BigDecimal(values[12]))
                .totalProfit(new BigDecimal(values[13]))
                .build();
    };

    /**
     * Main function that handles the read of csv and conversion to List{@link SellResource}
     *
     * @param path Path of url
     * @return List {@link SellResource}
     */
    public List<SellResource> processFile(String path) {
        log.info("Processing CSV to list");
        List<SellResource> sellResourceList = new ArrayList<>();

        File csvFile = new File(path);

        try {
            InputStream inputStream = new FileInputStream(csvFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            sellResourceList = bufferedReader.lines()
                    .skip(1)
                    .map(mapToSellResource)
                    .collect(Collectors.toList());

            bufferedReader.close();
            inputStream.close();
        } catch (IOException exception) {
            throw new RuntimeException("Problem reading the file");
        }

        log.info("Done processing CSV to list");
        return sellResourceList;
    }

    /**
     * Function that convert string with pattern (d/MM/yyyy) to {@link LocalDate}
     *
     * @param dateString String to process
     * @return {@link LocalDate}
     */
    private LocalDate convertStringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(dateString, formatter);
    }
}
