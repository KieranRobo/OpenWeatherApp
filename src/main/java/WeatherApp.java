import controller.WeatherController;
import model.CommandLineInput;
import service.WeatherService;

public class WeatherApp {

    private static final String apiUrl = "https://api.openweathermap.org/data/2.5";
    private static String apiKey;

    public static void main(String[] args) {
        apiKey = System.getenv("WEATHER_API_KEY");
        if (apiKey.equals("")) {
            throw new RuntimeException("no api key");
        }

        WeatherController weatherController = new WeatherController(apiUrl, apiKey);
        weatherController.executeRequest(parseInput(args));
    }

    private static CommandLineInput parseInput(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("no request type");
        }
        CommandLineInput commandLineInput = new CommandLineInput();
        commandLineInput.setCity(args[0]);
        commandLineInput.setRequestType("summary");

        for (int i=1; i<args.length; i++) {
            if (args[i].equals("detailed")) {
                commandLineInput.setRequestType("detailed");
            }
        }
        return commandLineInput;
    }
}

// WeatherApp.java glasgow now --summary
// WeatherApp.java glasgow tomorrow --summary
// WeatherApp.java glasgow thursday --summary
// WeatherApp.java glasgow next week --summary
