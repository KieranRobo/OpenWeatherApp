package model;

public class CommandLineInput {
    private String city;
    private String requestType;

    public CommandLineInput(String city, String requestType) {
        this.city = city;
        this.requestType = requestType;
    }

    public CommandLineInput() { }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
