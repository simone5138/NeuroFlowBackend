package Neuroflow.backend.treatmentpath.mapper;

import Neuroflow.backend.treatmentpath.dto.TreatmentPathCreateRequest;
import Neuroflow.backend.treatmentpath.dto.TreatmentPathDto;
import Neuroflow.backend.treatmentpath.dto.TreatmentPathUpdateRequest;
import Neuroflow.backend.treatmentpath.entity.TreatmentPath;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TreatmentPathMapper {

    TreatmentPathDto toDto(TreatmentPath entity);

    List<TreatmentPathDto> toDtoList(List<TreatmentPath> entities);

    @Mapping(target = "id", ignore = true)
    TreatmentPath toEntity(TreatmentPathCreateRequest req);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(TreatmentPathUpdateRequest req, @MappingTarget TreatmentPath entity);
}

