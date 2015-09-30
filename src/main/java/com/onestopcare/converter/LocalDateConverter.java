package com.onestopcare.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        Instant instant = Instant.from(attribute);

        return Date.from(instant);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        final Instant instant = dbData.toInstant();

        return LocalDate.from(instant);
    }
}
