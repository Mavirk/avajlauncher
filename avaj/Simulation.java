package avaj;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {
    WeatherTower weatherTower = new WeatherTower();
    private static int          simCount;
    private static List<Flyable> flyables = new List<Flyable>();
    public static void main(String[] args) {
        String[] fileArray;
        if (args.length != 1){
            System.out.println("Please provide ONLY a simulation.txt file as args");
            return;
        }
        try{
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            
            String temp = bufferedReader.readLine();
            String line = null;
            
            simCount = Integer.parseInt(temp);
            System.out.println(simCount);
            while ((line = bufferedReader.readLine()) != null){
                String[] splitLine = line.split(" ");
                Flyable f = AircraftFactory.newAircraft(
                    splitLine[0],
                    splitLine[1],
                    splitLine[2],
                    splitLine[3],
                    splitLine[4]);
                lines.add(line);
                f.registerTower(weatherTower);
                flyables.add(f);
            }

            for (Flyables f:flyables){
                System.out.println(f.getClass());
            }

            bufferedReader.close();
            fileArray = lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("File Not Found" + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Null Pointer" + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("not a valid number" + e.getMessage());
        }

        fileArray = readFile(args[0]);
        for (String s : fileArray){
            System.out.println(s);
        }
    }
}
