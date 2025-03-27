package com.revolution.details.service.infrastructure.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revolution.common.event.RegisterEvent;
import com.revolution.common.event.Topics;
import com.revolution.details.service.api.port.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
class RegisterListener {

    private static final String GROUP_ID = "details-service-group";

    private final AddressService addressService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = Topics.REGISTER_TOPIC, groupId = GROUP_ID)
    void listen(String payload) throws JsonProcessingException {
        log.info("Received RegisterEvent: {}", payload);
        RegisterEvent event = objectMapper.readValue(payload, RegisterEvent.class);
        addressService.createAddress(event.userId());
    }
}
