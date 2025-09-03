package ru.nikitanevmyvaka.monitorsensors.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorCreateRequest;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorRangeDTO;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorResponse;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorUpdateRequest;
import ru.nikitanevmyvaka.monitorsensors.model.Sensor;
import ru.nikitanevmyvaka.monitorsensors.model.SensorRange;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SensorMapper {

    @Mapping(target = "id",ignore = true)
    Sensor toEntity(SensorCreateRequest dto);

    SensorRange toEntitySensorRange(SensorRangeDTO rangeDto);

    SensorRangeDTO toDto(SensorRange sensorRange);

    void update(@MappingTarget Sensor target, SensorUpdateRequest dto);


    SensorResponse toResponse(Sensor sensor);
}
