package controller;

import model.CommandLineInput;
import service.WeatherService;

public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(String apiUrl, String apiKey) {
        this.weatherService = new WeatherService(apiUrl, apiKey);
    }

    public void executeRequest(CommandLineInput commandLineInput) {
        switch (commandLineInput.getRequestType()) {
            case "summary":
                System.out.print(weatherService.fetchCurrentWeather(commandLineInput.getCity()).getLocation());
                break;
            case "detailed":
                // System.out.print(weatherService.fetchCurrentWeather(commandLineInput.getCity()).getLocation());
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }
}
