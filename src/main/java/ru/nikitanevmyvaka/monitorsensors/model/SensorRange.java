package ru.nikitanevmyvaka.monitorsensors.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class SensorRange {

    @NotNull (message = "from value must be not null")
    @Positive(message = "from value must be positive")
    @Column(name = "range_from")
    private  Integer from;

    @NotNull (message = "to value must be not null")
    @Positive (message = "to value must be positive")
    @Column(name = "range_to")
    private Integer to;

    @AssertTrue(message = "from value must be < than to value")
    public boolean isValidRange(){


        if(this.from>=this.to){
            return false;
        }

        return true;
    }


}
