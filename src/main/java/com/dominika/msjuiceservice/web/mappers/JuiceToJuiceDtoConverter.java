package com.dominika.msjuiceservice.web.mappers;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.dominika.msjuiceservice.domain.Juice;
import com.dominika.msjuiceservice.web.model.JuiceDto;
import org.springframework.core.convert.converter.Converter;

public class JuiceToJuiceDtoConverter implements Converter<Juice, JuiceDto> {
    @Override
    public JuiceDto convert(final Juice source) {
        return JuiceDto.builder()
            .createdDate(asOffsetDateTime(source.getCreatedDate()))
            .juiceName(source.getJuiceName())
            .juiceStyle(source.getJuiceStyle())
            .upc(source.getUpc())
            .price(source.getPrice())
            .version(source.getVersion())
            .build();
    }

    public OffsetDateTime asOffsetDateTime(Timestamp ts){
        if (ts != null){
            return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(),
                ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(), ts.toLocalDateTime().getMinute(),
                ts.toLocalDateTime().getSecond(), ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }
}
