package com.ctech.consumer2.engine;


import com.ctech.consumer2.City;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "weather", groupId = "consumer-2")
    public void consume(byte [] message) throws IOException {
        final Decoder decoder = DecoderFactory.get().binaryDecoder(new ByteArrayInputStream(message), null);
        DatumReader<City> reader = new SpecificDatumReader<>(City.class);


        City city = reader.read(null, decoder);

        logger.info(String.format("#### -> Consumed message but extracted from WeatherData object -> %s", city.toString()));
    }
}