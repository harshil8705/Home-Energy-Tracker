package com.harshilInfotech.injestionService.service;

import com.harshilInfotech.injestionService.dto.EnergyUsageDto;
import com.harshilInfotech.injestionService.kafka.event.EnergyUsageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngestionServiceImpl implements IngestionService{

    private final KafkaTemplate<String, EnergyUsageEvent> kafkaTemplate;

    @Override
    public void ingestEnergyUsage(EnergyUsageDto input) {

        EnergyUsageEvent event = EnergyUsageEvent.builder()
                .deviceId(input.deviceId())
                .energyConsumed(input.energyConsumed())
                .timeStamp(input.timeStamp())
                .build();

        kafkaTemplate.send("energy-usage", event);
        log.info("Ingested Energy Usage Event: {}", event);

    }
}
