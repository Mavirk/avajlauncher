public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Please provide ONLY a simulation.txt file as args");
            return;
        }
        String s = args[0];
        File file = new File("simulation.txt");
        
        System.out.println("this is my programme");
    }
}