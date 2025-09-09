package ru.nikitanevmyvaka.monitorsensors.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import ru.nikitanevmyvaka.monitorsensors.model.SensorRange;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Type;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Unit;

public record SensorCreateRequest(
        @Schema(example = "Sensor1") @NotBlank @Size(min = 3, max = 30)
        String name,

        @Schema(example = "AS-23") @NotBlank @Size(max = 15) String model,

        @Schema(example = "Temperature")@Valid SensorRangeDTO range,


        @Schema(example = "temperature")@NotNull Type type,

        @Schema(example = "bar")@NotNull Unit unit,

        @Schema(example = "kitchen")@Size(max = 40) String location,

        @Schema(example = "sensor as-23 at kitchen")@Size(max = 200) String description


) {
}




