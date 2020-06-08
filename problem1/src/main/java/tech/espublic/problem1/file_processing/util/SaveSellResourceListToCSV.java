package tech.espublic.problem1.file_processing.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.espublic.problem1.file_processing.resource.SellResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.UUID;

/**
 * Class that will handle the save of the new document that is order
 */
@Component
@Slf4j
public class SaveSellResourceListToCSV {

    private final String[] headerCSV = new String[]{
            "Region", "Country", "Item Type", "Sales Channel", "Order Priority", "Order Date", "Order ID",
            "Ship Date", "Units Sold", "Unit Price", "Unit Cost", "Total Revenue", "Total Cost", "Total Profit"
    };

    /**
     * Function that handles the write of the CSV
     *
     * @param path Path of the file that read to save in the save folder
     * @param sellResourceList List {@link SellResource}
     */
    public void writeToCSV(String path, List<SellResource> sellResourceList) {
        File file = new File(path);

        // Create the new file name
        String pathOfNewFile =
                file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator))
                + File.separator
                + file.getName().substring(0, file.getName().lastIndexOf("."))
                + "_" + UUID.randomUUID()+ ".csv";

        file = new File(pathOfNewFile);

        try {
            log.info("Writing new file at {}", file.getAbsolutePath());

            OutputStream outputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            String header = String.join(",", headerCSV);

            bufferedWriter.write(header);

            for (SellResource sellResource : sellResourceList) {
                bufferedWriter.newLine();
                bufferedWriter.write(sellResource.sellResourceToCSVLine());
            }

            bufferedWriter.close();
            outputStream.close();
        } catch (IOException exception) {
            throw new RuntimeException("Problem writing the file");
        }
    }
}
