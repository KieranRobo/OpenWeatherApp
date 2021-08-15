package service;

import model.LocationWeatherOverview;
import util.RequestBuilder;
import util.mapper.CurrentWeatherMapper;

public class WeatherFetcherService {

    private static final String apiKey = System.getenv("WEATHER_API_KEY");

    private static final String apiUrl = "https://api.openweathermap.org/data/2.5";

    public static LocationWeatherOverview fetchCurrentWeather(String city) {
        if (city == null || city.isEmpty()) {
            throw new RuntimeException("City cannot be empty");
        }

        String resp = RequestBuilder.makeRequest(apiUrl + "/weather?q=" + city + "&appid=" + apiKey);
        LocationWeatherOverview weather = CurrentWeatherMapper.mapWeather(resp);

        return weather;
    }

}
