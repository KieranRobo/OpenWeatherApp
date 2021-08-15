package model;

public class LocationWeatherOverview {

    private String location;
    private GeneralWeather generalWeather;

    public LocationWeatherOverview(String location, GeneralWeather generalWeather) {
        this.location = location;
        this.generalWeather = generalWeather;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GeneralWeather getGeneralWeather() {
        return generalWeather;
    }

    public void setGeneralWeather(GeneralWeather generalWeather) {
        this.generalWeather = generalWeather;
    }

}
