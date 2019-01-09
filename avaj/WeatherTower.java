package avaj;

import avaj.Coordinates;
public class WeatherTower extends Tower{
    public WeatherTower(){
        
    }
    public String getWeather(Coordinates coordinates) {

        return "SUN";
    }
    void changeWeather(){
        this.conditionsChanged();
    }
}