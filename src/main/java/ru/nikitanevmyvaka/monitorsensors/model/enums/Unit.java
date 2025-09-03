package ru.nikitanevmyvaka.monitorsensors.model.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import ru.nikitanevmyvaka.monitorsensors.exceptions.MissingArgumentException;

import java.util.Arrays;

public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    PERCENT("%"),
    CELCIUS("°C");

    private final String symbol;

    Unit(String symbol){
        this.symbol= symbol;
    }

    @JsonValue
    public String getSymbol(){
        return symbol;
    }

    @JsonCreator
    public static Unit from(String value){
        if (value==null) throw new IllegalArgumentException("Unit is null");

        String normalized= value.trim();

        for(Unit unit: values()){
            if(unit.symbol.equalsIgnoreCase(normalized)) return unit;

        }

        return Arrays.stream(values())
                .filter(u -> u.name().equalsIgnoreCase(normalized))
                .findFirst()
                .orElseThrow(() -> new MissingArgumentException("Unit not found"));





    }


}
