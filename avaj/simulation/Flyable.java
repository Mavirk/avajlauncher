package simulation;
public interface Flyable {
    Coordinates getCoords();
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}