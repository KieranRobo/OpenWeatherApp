package util.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.LocationWeatherOverview;
import model.response.WeatherResponse;

public class CurrentWeatherMapper {

    public static LocationWeatherOverview mapWeather(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = objectMapper.readValue(json, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new LocationWeatherOverview(weatherResponse.getName(), null);
    }
}
