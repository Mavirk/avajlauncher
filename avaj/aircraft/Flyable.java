package com.avaj.aircraft;
import  com.avaj.simulation.weather;
public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}