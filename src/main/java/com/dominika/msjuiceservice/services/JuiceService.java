package com.dominika.msjuiceservice.services;

import java.util.UUID;

import com.dominika.msjuiceservice.web.model.JuiceDto;

public interface JuiceService {
    JuiceDto getJuiceById(final UUID juiceId);

    JuiceDto saveNewJuice(JuiceDto juiceDto);

    JuiceDto updateJuice(UUID juiceId, JuiceDto juiceDto);
}
