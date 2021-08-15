import service.WeatherFetcherService;

public class WeatherApp {

    public static void main(String[] args) {
        System.out.print(WeatherFetcherService.fetchCurrentWeather("glasgow").getLocation());
    }
}

// WeatherApp.java glasgow now --summary
// WeatherApp.java glasgow tomorrow --summary
// WeatherApp.java glasgow thursday --summary
// WeatherApp.java glasgow next week --summary
