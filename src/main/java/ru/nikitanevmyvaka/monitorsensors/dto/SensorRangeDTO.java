package ru.nikitanevmyvaka.monitorsensors.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorRangeDTO {

    @NotNull (message = "to value must be not null")
    @Positive  (message = "to value must be positive")
    private Integer to;

    @NotNull (message = "from value must be not null")
    @Positive (message = "from value must be positive")
    private Integer from;


    @AssertTrue(message = "from must be < than to")
    public boolean isValidRange(){

        if(this.from>=this.to) return false;

        return true;

    }


}
