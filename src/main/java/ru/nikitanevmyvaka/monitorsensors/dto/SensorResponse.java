package ru.nikitanevmyvaka.monitorsensors.dto;

import ru.nikitanevmyvaka.monitorsensors.model.SensorRange;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Type;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Unit;

public record SensorResponse(
        Long id,
        String name,
        String model,
        SensorRangeDTO range,
        Type type,
        Unit unit,
        String location,
        String description

) {
}
