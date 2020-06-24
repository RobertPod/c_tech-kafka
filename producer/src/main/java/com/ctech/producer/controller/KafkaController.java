package com.ctech.producer.controller;

import com.ctech.producer.City;
import com.ctech.producer.dto.CityDTO;
import com.ctech.producer.engine.Producer;
import com.ctech.producer.service.WeatherService;
import com.ctech.producer.utils.ByteArraySerializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    private final WeatherService weatherService;

    @Autowired
    KafkaController(final Producer producer, final WeatherService weatherService) {
        this.producer = producer;
        this.weatherService = weatherService;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody CityDTO cityDTO) throws IOException {
        City cityDataToSerialize = weatherService.getWeatherDataForCity(cityDTO);
        byte[] agreementByteArray = ByteArraySerializerUtil.serialize(cityDataToSerialize);
        this.producer.sendMessage(agreementByteArray);
    }
}