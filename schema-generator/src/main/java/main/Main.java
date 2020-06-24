package main;

import schemabuilder.AvroSchemaBuilder;
import schemas.WeatherDataSchema;

public class Main {

    public static void main(String[] args) {
        WeatherDataSchema agreementSchema = new WeatherDataSchema();
        AvroSchemaBuilder.writeSchemaToAFile(agreementSchema.buildSchema(), "WeatherForPolishCities.avsc");
    }
}
