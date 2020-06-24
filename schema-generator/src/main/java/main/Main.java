package main;

import schemabuilder.AvroSchemaBuilder;
import schemas.AlertSchema;
import schemas.WeatherDataSchema;

public class Main {

    public static void main(String[] args) {
        WeatherDataSchema weatherDataSchema = new WeatherDataSchema();
        AlertSchema alertSchema = new AlertSchema();
        AvroSchemaBuilder.writeSchemaToAFile(weatherDataSchema.buildSchema(), "WeatherForPolishCities.avsc");
        AvroSchemaBuilder.writeSchemaToAFile(alertSchema.buildSchema(), "Alert.avsc");
    }
}
