package com.dominika.msjuiceservice.web.controller;

import java.util.UUID;

import com.dominika.msjuiceservice.web.model.JuiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/juice")
@RestController
public class JuiceController {

    @GetMapping("/{juiceId}")
    public ResponseEntity<JuiceDto> getJuiceById(@PathVariable UUID juiceId){
        //TODO impl
        return new ResponseEntity<>(JuiceDto.builder().build(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveNewJuice (@RequestBody @Validated JuiceDto juiceDto){
        //TODO impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{juiceid}")
    public ResponseEntity updateJuice(@PathVariable UUID juiceId, @RequestBody @Validated JuiceDto juiceDto){
        //TODO impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
