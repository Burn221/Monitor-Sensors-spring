package ru.nikitanevmyvaka.monitorsensors.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import ru.nikitanevmyvaka.monitorsensors.model.SensorRange;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Type;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Unit;

public record SensorUpdateRequest(
        @NotNull @Positive Long id,

        @NotBlank @NotNull @Size(min = 3,max = 30)
        String name,

        @NotBlank @Size(max = 15) String model,

        @Valid SensorRangeDTO range,

        @NotNull Type type,

        @NotNull Unit unit,

        @Size(max =40) String location,

        @Size(max=200) String description
) {
}
