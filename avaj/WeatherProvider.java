package avaj;

class WeatherProvider{
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    // Methods
    WeatherProvider(){

    }

    // Getters
    public static WeatherProvider getProvider(){
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        return "SUN";
    }
}