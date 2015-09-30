package com.onestopcare.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        Instant instant = Instant.from(attribute);

        return Date.from(instant);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        final Instant instant = dbData.toInstant();

        return LocalDateTime.from(instant);
    }
}
