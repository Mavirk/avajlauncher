package com.avaj.simulation;
import java.util.Random;

public class WeatherProvider{
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    // Methods
    public WeatherProvider(){
        weatherProvider = this;
    }

    // Getters
    public static WeatherProvider getProvider(){

        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        return weather[(coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4];
    }
}