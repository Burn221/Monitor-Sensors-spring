package ru.nikitanevmyvaka.monitorsensors.model.enums.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Unit;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit,String> {


    @Override
    public String convertToDatabaseColumn(Unit unit){
        return unit==null ? null : unit.getSymbol();

    }

    @Override
    public Unit convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : Unit.from(dbValue);
    }


}
