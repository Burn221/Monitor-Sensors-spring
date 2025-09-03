package ru.nikitanevmyvaka.monitorsensors.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import ru.nikitanevmyvaka.monitorsensors.exceptions.MissingArgumentException;

import java.util.Arrays;

public enum Type {
    PRESSURE("pressure"),
    VOLTAGE("voltage"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity");

    private final String displayName;

    Type(String displayName){
        this.displayName=displayName;
    }


    @JsonValue
    public String getDisplayName(){
        return displayName;
    }

    @JsonCreator
    public static Type from(String value){
        if(value==null) throw new IllegalArgumentException("Type can't be null");

        String normalized= value.trim();

        for(Type t: values()){
            if(t.displayName.equalsIgnoreCase(normalized)) return t;
        }

        return Arrays.stream(values())
                .filter(t-> t.name().equalsIgnoreCase(normalized))
                .findFirst()
                .orElseThrow(()-> new MissingArgumentException("Type not found"));


    }



}
