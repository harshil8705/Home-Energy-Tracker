package com.harshilInfotech.injestionService.service;

import com.harshilInfotech.injestionService.dto.EnergyUsageDto;

public interface IngestionService {

    void ingestEnergyUsage(EnergyUsageDto energyUsageDto);

}
