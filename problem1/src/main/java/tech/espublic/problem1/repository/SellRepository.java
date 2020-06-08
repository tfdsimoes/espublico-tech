package tech.espublic.problem1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tech.espublic.problem1.domain.Sell;

import java.util.List;

/**
 * Sell spring data repository
 */
public interface SellRepository extends CrudRepository<Sell, String> {

    @Query("SELECT s.region as data, COUNT(s.id) as counter FROM sell s GROUP BY s.region")
    List<CounterData> countByRegion();

    @Query("SELECT s.country as data, COUNT(s.id) as counter FROM sell s GROUP BY s.country")
    List<CounterData> countByCountry();

    @Query("SELECT s.itemType as data, COUNT(s.id) as counter FROM sell s GROUP BY s.itemType")
    List<CounterData> countByItemType();

    @Query("SELECT s.salesChannel as data, COUNT(s.id) as counter FROM sell s GROUP BY s.salesChannel")
    List<CounterData> countBySalesChannel();

    @Query("SELECT s.orderPriority as data, COUNT(s.id) as counter FROM sell s GROUP BY s.orderPriority")
    List<CounterData> countByOrderPriority();

    interface CounterData {
        String getData();

        Integer getCounter();
    }
}
