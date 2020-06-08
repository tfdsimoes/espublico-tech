package tech.espublic.problem1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.espublic.problem1.domain.Sell;
import tech.espublic.problem1.file_processing.resource.SellResource;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ON_IMPLICIT_CONVERSION;

/**
 * Interface responsible to map {@link SellResource} to {@link Sell}
 */
@Mapper(nullValueCheckStrategy = ON_IMPLICIT_CONVERSION)
public interface SellMapper {

    SellMapper INSTANCE = Mappers.getMapper(SellMapper.class);

    @Mapping(target = "id", ignore = true)
    Sell sellResourceToSell(SellResource sellResource);

    List<Sell> sellResourceListToSellList(List<SellResource> sellResourceList);
}
