package com.avaj.simulation;

class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    // Methods
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions() {
        int latitude = coordinates.getLatitude();
        int longitude = coordinates.getLongitude();
        int height = coordinates.getHeight();
//        System.out.println(name +" coordinates are ::"+"(lat " + latitude + ", long " + longitude + ", height " + height + ")");
        String message = "default";
        String[] messages = {
            "The sun is shining so smooth skies.",
            "Dammit its raining and my windscreen wiper is not working.",
            "I cant see anything through this fog.",
            "Its snowing and my rotor is freezing up"
        };
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                longitude = longitude + 10;
                height = height + 2;
                message = messages[0];
                break;
            case "RAIN":
                longitude = longitude + 5;
                message = messages[1];
                break;
            case "FOG":
                longitude = longitude + 1;
                message = messages[2];
                break;
            case "SNOW":
                height = height - 12;
                message = messages[3];
                break;
        }
        if (height <= 0){
            Writer.writeLines(this.getClass().getSimpleName()+ "#" + this.name + "(" + this.id + "):" + " landing at (long " + coordinates.getLongitude() + ", lat " + coordinates.getLatitude() + ")" );weatherTower.unregister(this);
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