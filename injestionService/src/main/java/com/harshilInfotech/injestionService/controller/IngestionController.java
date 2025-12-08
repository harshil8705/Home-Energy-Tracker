package com.harshilInfotech.injestionService.controller;

import com.harshilInfotech.injestionService.dto.EnergyUsageDto;
import com.harshilInfotech.injestionService.service.IngestionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingestion")
public class IngestionController {

    private final IngestionServiceImpl ingestionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void ingestionData(@RequestBody EnergyUsageDto energyUsageDto) {

        ingestionService.ingestEnergyUsage(energyUsageDto);

    }

}
