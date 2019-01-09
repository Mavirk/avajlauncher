package avaj;
import java.io.*;
import java.util.*;

class   Tower{
    private List<Flyable> observers;
    private List<Flyable> landed;
    // Methods
    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){
        observers.remove(flyable);
        landed.add(flyable);
    }
    protected void conditionsChanged(){
        
    }
}