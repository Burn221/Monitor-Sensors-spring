package ru.nikitanevmyvaka.monitorsensors.model.enums.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Type;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type,String> {

    @Override
    public String convertToDatabaseColumn(Type type) {
        return type==null ? null : type.getDisplayName();
    }

    @Override
    public Type convertToEntityAttribute(String dbValue) {
        return dbValue==null ? null : Type.from(dbValue);
    }


}
