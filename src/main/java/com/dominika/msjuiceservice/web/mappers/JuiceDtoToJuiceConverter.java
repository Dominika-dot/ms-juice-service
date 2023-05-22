package com.dominika.msjuiceservice.web.mappers;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.dominika.msjuiceservice.domain.Juice;
import com.dominika.msjuiceservice.web.model.JuiceDto;
import org.springframework.core.convert.converter.Converter;

public class JuiceDtoToJuiceConverter implements Converter<JuiceDto, Juice> {
    @Override
    public Juice convert(final JuiceDto source) {
        return Juice.builder()
            .createdDate(asTimestamp(source.getCreatedDate()))
            .juiceName(source.getJuiceName())
            .juiceStyle(source.getJuiceStyle())
            .upc(source.getUpc())
            .price(source.getPrice())
            .version(source.getVersion())
            .build();
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime){
        if(offsetDateTime != null) {
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }
}