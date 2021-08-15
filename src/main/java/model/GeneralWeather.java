package model;

public class GeneralWeather {
    private String overview;
    private String description;

    public GeneralWeather(String overview, String description) {
        this.overview = overview;
        this.description = description;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
