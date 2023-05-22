package com.dominika.msjuiceservice.web.controller;

import java.util.UUID;

import com.dominika.msjuiceservice.services.JuiceService;
import com.dominika.msjuiceservice.web.model.JuiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/juice")
@RestController
@RequiredArgsConstructor
public class JuiceController {

    private final JuiceService juiceService;

    @GetMapping("/{juiceId}")
    public ResponseEntity<JuiceDto> getJuiceById(@PathVariable UUID juiceId){
        return new ResponseEntity<>(juiceService.getJuiceById(juiceId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<JuiceDto> saveNewJuice (@RequestBody @Validated JuiceDto juiceDto){
        return new ResponseEntity<>(juiceService.saveNewJuice(juiceDto), HttpStatus.CREATED);
    }

    @PutMapping("/{juiceid}")
    public ResponseEntity updateJuice(@PathVariable UUID juiceId, @RequestBody @Validated JuiceDto juiceDto){
        return new ResponseEntity(juiceService.updateJuice(juiceId, juiceDto), HttpStatus.NO_CONTENT);
    }
}
