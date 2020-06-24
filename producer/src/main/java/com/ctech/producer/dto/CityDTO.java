package com.ctech.producer.dto;

import java.util.List;

public class CityDTO {

    private String cityName;
    private String voivodeship;
    private List<WeatherDataDTO> weatherData;

    public String getCityName() {
        return cityName;
    }

    public CityDTO cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public CityDTO voivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
        return this;
    }

    public List<WeatherDataDTO> getWeatherData() {
        return weatherData;
    }

    public CityDTO weatherData(List<WeatherDataDTO> weatherData) {
        this.weatherData = weatherData;
        return this;
    }
}
