package avaj;
// import avaj.simulation;
// import avaj.aircraft;

class Aircraft extends Flyable {
    protected long id;
    protected String name ;
    protected Coordinates coordinates;
    private static long _idCounter = 0L;
    
    protected void Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this._idCounter = nextId();
        this.id = this._idCounter;
        return;   
    }
    private long nextId(){
        long x = 0;
        return x;
    }
}
