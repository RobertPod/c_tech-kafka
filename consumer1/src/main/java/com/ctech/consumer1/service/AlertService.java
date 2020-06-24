package com.ctech.consumer1.service;


import com.ctech.consumer1.Alert;
import com.ctech.consumer1.City;
import com.ctech.consumer1.engine.Producer;
import com.ctech.consumer1.utils.ByteArraySerializerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class AlertService {
    private final Logger logger = LoggerFactory.getLogger(AlertService.class);
    private final Producer producer;

    @Autowired
    public AlertService(final Producer producer) {
        this.producer = producer;

    }

    public void sendAlertIfTempBelow(City city) {
        city.getWeatherDatas().forEach(weatherData-> {
            if(Long.parseLong(weatherData.getTemperature()) > 20L) {
                Alert alert = new Alert();
                alert.setMessage("Alert RCB : JEST ZA GORĄCO nie wyłaź ! https://www.pepper.pl/promocje/piwo-lomza-jasne-05l-puszka-199-lidl-274753?fbclid=IwAR048v78dsQID-WDq4eQEFVUTBnDaz63lNJ5NyESPL2H5NJd8ijjQ-haang");
                try {
                    this.producer.sendMessage(ByteArraySerializerUtil.serialize(alert));
                    logger.info(String.format("#### -> Produced alert from Consumer 1 -> %s", alert.toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
