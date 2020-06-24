package com.ctech.producer.dto;

public class WeatherDataDTO {
    private String temperature;
    private String pressure;
    private String message;

    public String getTemperature() {
        return temperature;
    }

    public WeatherDataDTO temperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getPressure() {
        return pressure;
    }

    public WeatherDataDTO pressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public WeatherDataDTO message(String message) {
        this.message = message;
        return this;
    }
}
