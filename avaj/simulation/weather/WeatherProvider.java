package com.avaj.simulation.weather;
class WeatherProvider{
    private static WeatherProvider weatherProvider;
    private static String[] weather;
    // Methods
    WeatherProvider(){}

    // Getters
    public static WeatherProvider getProvider(){
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        return "hey";
    }
}