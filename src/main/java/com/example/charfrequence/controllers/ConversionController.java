package com.example.charfrequence.controllers;

import com.example.charfrequence.services.ConversionService;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @GetMapping("/convert")
    private Map<String, Integer> getCharFrequencyResponse (@RequestParam @NotEmpty String message) {
        return conversionService.getCharFrequency(message);
    }

}
