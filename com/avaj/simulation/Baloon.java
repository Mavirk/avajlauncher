package com.avaj.simulation;

public class Baloon extends Aircraft implements Flyable{
   private WeatherTower weatherTower;

   // Methods
   protected Baloon(String name, Coordinates coordinates){
      super(name, coordinates);
   }
   public void updateConditions() {
      int latitude = coordinates.getLatitude();
      int longitude = coordinates.getLongitude();
      int height = coordinates.getHeight();
      String message = "default";
      String[] messages = {
              "What a wonderful sunny day for balooning",
              "Watch out for lighting",
              "Its so foggy that we cant see the ground",
              "When its snows we go down ...quickly"
      };
      String weather = this.weatherTower.getWeather(this.coordinates);
      switch(weather){
         case "SUN":
            longitude = longitude + 2;
            height = height + 4;
            message = messages[0];
            break;
         case "RAIN":
            height = height - 5;
            message = messages[1];
            break;
         case "FOG":
            height = height - 3;
            message = messages[2];
            break;
         case "SNOW":
            height = height - 15;
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
      return;
   }
   public Coordinates getCoords(){
      return this.coordinates;
   }
}