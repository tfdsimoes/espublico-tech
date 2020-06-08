package tech.espublic.problem1.executer;

import org.springframework.stereotype.Component;
import tech.espublic.problem1.repository.SellRepository;

import java.util.List;

@Component
public class ResumeData {

    private final SellRepository sellRepository;

    public ResumeData(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }

    public void showResumeOfData() {
        System.out.println("Region:");
        printInformationQuery(sellRepository.countByRegion());

        System.out.println("Country:");
        printInformationQuery(sellRepository.countByCountry());

        System.out.println("Item Type:");
        printInformationQuery(sellRepository.countByItemType());

        System.out.println("Sales Channel:");
        printInformationQuery(sellRepository.countBySalesChannel());

        System.out.println("Order Priority:");
        printInformationQuery(sellRepository.countByOrderPriority());
    }

    private void printInformationQuery(List<SellRepository.CounterData> counterDataList) {
        for(SellRepository.CounterData counterData : counterDataList) {
            System.out.printf("\t %s - % d\n", counterData.getData(), counterData.getCounter());
        }
    }
}
