package schemas;



import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.util.ArrayList;


public class WeatherDataSchema implements AvroSchema {
    @Override
    public String buildSchema() {
        Schema weatherData = SchemaBuilder.record("WeatherData")
                                          .namespace("com.ctech.producer")
                                          .fields()
                                          .requiredString("temperature")
                                          .requiredString("pressure")
                                          .requiredString("message")
                                          .endRecord();

        Schema city = SchemaBuilder.record("City")
                                     .namespace("com.ctech.producer")
                                     .fields()
                                     .requiredString("cityname")
                                     .requiredString("voivodeship")
                                     .name("weatherDatas")
                                     .type()
                                     .array()
                                     .items()
                                     .type(weatherData)
                                     .arrayDefault(new ArrayList<>())
                                     .endRecord();

        return city.toString();
    }
}
