package com.dominika.msjuiceservice.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import com.dominika.msjuiceservice.domain.Juice;
import com.dominika.msjuiceservice.repositories.JuiceRepository;
import com.dominika.msjuiceservice.web.model.JuiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JuiceServiceImpl implements JuiceService{

    private final JuiceRepository juiceRepository;
    private final ConversionService conversionService;

    @Override
    public JuiceDto getJuiceById(final UUID juiceId) {
        return conversionService.convert(
            juiceRepository.findById(juiceId), JuiceDto.class);
    }

    @Override
    public JuiceDto saveNewJuice(final JuiceDto juiceDto) {
        return conversionService.convert(
            juiceRepository.save(
                conversionService.convert(juiceDto, Juice.class)), JuiceDto.class);
    }

    @Override
    public JuiceDto updateJuice(final UUID juiceId, final JuiceDto juiceDto) {
        return juiceRepository.findById(juiceId)
            .map(j -> updateJuiceFields(j, juiceDto))
           // .map(juiceRepository::save) -> to się dzieje automagicznie
            .map(j -> conversionService.convert(j, JuiceDto.class)).get();

    }

    private Juice updateJuiceFields(final Juice juice, final JuiceDto juiceDto) {
        return Juice.builder()
            .juiceName(juiceDto.getJuiceName())
            .juiceStyle(juiceDto.getJuiceStyle())
            .price(juiceDto.getPrice())
            .minOnHand(juiceDto.getQuantityOnHand())
            .quantityToBrew(juice.getQuantityToBrew())
            .upc(juiceDto.getUpc())
            .id(juice.getId())
            .version(juiceDto.getVersion())
            .lastModifiedDate(Timestamp.from(Instant.now()))
            .build();
    }
}
