package avaj;

class Coordinates {
// Attributes
    private int longitude;
    private int latitude;
    private int height;

// Methods
    Coordinates(int longitude, int latitude, int height){
        this.latitude = latitude;
        this.latitude = latitude;
        if (height > 100)
            this.height = 100;
        else
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