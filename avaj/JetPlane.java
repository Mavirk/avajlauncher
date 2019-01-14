package simulation;
public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    // Methods
    protected JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        int latitude = coordinates.getLatitude();
        int longitude = coordinates.getLongitude();
        int height = coordinates.getHeight();

        String message = "default";
        String[] messages = {
                "Sunshine oh sweet sunshine!!!",
                "We just hit a thunderstorm its raining",
                "Its time fro instruments only flying...fog just rolled in",
                "Look its snowing"
        };
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                latitude = latitude + 10;
                height = height + 2;
                message = messages[0];
                break;
            case "RAIN":
                latitude = latitude + 5;
                message = messages[1];
                break;
            case "FOG":
                latitude = longitude + 1;
                message = messages[2];
                break;
            case "SNOW":
                height = height - 7;
                message = messages[3];
                break;
        }
        if (height <= 0){
            Writer.writeLines(
                    this.getClass().getSimpleName()+ "#" + this.name + "(" + this.id + "):" +
                            " landing at (long " + coordinates.getLongitude() + ", lat " + coordinates.getLatitude() + ")" );
            weatherTower.unregister(this);
            return;
        }
        coordinates.setLatitude(latitude);
        coordinates.setLongitude(longitude);
        coordinates.setHeight(height);
        Writer.writeLines(this.getClass().getSimpleName() + "#" + this.name + "(" + id + ")" + message);
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }
    public Coordinates getCoords(){
        return this.coordinates;
    }

}
