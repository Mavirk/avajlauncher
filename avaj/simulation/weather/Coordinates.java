package com.avaj.simulation.weather;

class Coordinates {
// Attributes
    private int longitude;
    private int latitude;
    private int height;

// Methods
    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        return;
    }

// Getters
    protected int getLongitude() {
        return longitude;
    }
    protected int getLatitude() {
        return latitude;
    }    
    protected int getHeight() {
        return height;
    }    
}