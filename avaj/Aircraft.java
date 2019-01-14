package simulation;
// import avaj.simulation;
// import avaj.aircraft;

class Aircraft {
    protected long id;
    protected String name ;
    protected Coordinates coordinates;
    private static long idCounter = 0L;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.idCounter = nextId();
        this.id = this.idCounter;
        return;   
    }
    private long nextId(){
        return (++idCounter);
    }
}
