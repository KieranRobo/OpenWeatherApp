package service;

import model.LocationWeatherOverview;
import util.RequestBuilder;
import util.mapper.CurrentWeatherMapper;

import java.util.Map;

public class WeatherService {

    private final RequestBuilder requestBuilder;

    public WeatherService(String apiUrl, String apiKey) {
        this.requestBuilder = new RequestBuilder(apiUrl, apiKey);
    }

    public LocationWeatherOverview fetchCurrentWeather(String city) {
        if (city == null || city.isEmpty()) {
            throw new RuntimeException("City cannot be empty");
        }
        String resp = requestBuilder.makeRequest("weather", Map.of("q", city));
        return CurrentWeatherMapper.mapWeather(resp);
    }

}
