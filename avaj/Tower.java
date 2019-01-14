package simulation;
import java.util.ArrayList;
import java.util.List;

class   Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    String type;
    String name;
    long id;

    // Methods
    public void register(Flyable flyable) {
        observers.add(flyable);
        extractFlyableProperties(flyable);
        Writer.writeLines("Tower says: " + type + "#" + name + "(" + id + ")" + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        extractFlyableProperties(flyable);
        Writer.writeLines("Tower says: " + type + "#" + name + "(" + id + ")" + " unregistered from weather tower.");
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            Flyable aircraft = observers.get(i);
            if (aircraft.getCoords().getHeight() > 0) aircraft.updateConditions();
            else unregister(aircraft);
        }
    }

    private void extractFlyableProperties(Flyable flyable) {
        type = flyable.getClass().getSimpleName();
        switch (type) {
            case "Baloon":
                name = ((Baloon) flyable).name;
                id = ((Baloon) flyable).id;
                break;
            case "JetPlane":
                name = ((JetPlane) flyable).name;
                id = ((JetPlane) flyable).id;
                break;
            case "Helicopter":
                name = ((Helicopter) flyable).name;
                id = ((Helicopter) flyable).id;
                break;
            default:
                name = "error";
                id = -404;
        }
    }
}