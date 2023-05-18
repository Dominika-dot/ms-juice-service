package com.dominika.msjuiceservice.web.mappers;

import com.dominika.msjuiceservice.domain.Juice;
import com.dominika.msjuiceservice.web.model.JuiceDto;
import org.springframework.core.convert.converter.Converter;

public class JuiceToJuiceDtoConverter { //implements Converter<Juice, JuiceDto> {
//    @Override
//    public JuiceDto convert(final Juice source) {
//        return JuiceDto.builder()
//            .createdDate(source.getCreatedDate())
//            .juiceName(source.getJuiceName())
//            .juiceStyle(source.getJuiceStyle())
//            .upc(source.getUpc())
//            .price(source.getPrice())
//            .version(source.getVersion())
//            .build();
//    }
}
