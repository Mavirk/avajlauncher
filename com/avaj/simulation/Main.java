package com.avaj.simulation;

// import simulation.AircraftFactory;
// import simulation.Flyable;
// import simulation.WeatherTower;
// import simulation.WeatherProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Main {
    private static WeatherTower weatherTower = new WeatherTower();
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static int          simCount;

    private static boolean checkline(int lineNum, String type, String name, int longitude, int latitude, int elevation){
        int lineNumber = lineNum + 1;
        switch (type){
            case "Baloon":
                if (!Pattern.matches("B[0-9]+",name)) {
                    System.out.println("Input Error on line " + lineNumber +": second value -> '" + name + "' must be B followed by one or more a digit");
                    return false;
                }
                break;
            case "JetPlane":
                if (!Pattern.matches("J[0-9]+",name)) {
                    System.out.println("Input Error on line " + lineNumber +": second value -> '" + name + "' must be J followed by one or more a digit");
                    return false;
                }
                break;
            case "Helicopter":
                if (!Pattern.matches("H[0-9]+",name)) {
                    System.out.println("Input Error on line " + lineNumber +": second value -> '" + name + "' must be H followed by one or more a digit");
                    return false;
                }
                break;
            default:
                System.out.println("Input Error on line " + lineNumber +": First value -> '" + type + "' must be 'Baloon', 'JetPlane' or 'Helicopter'");
                return false;
        }
        if (longitude < 0 || elevation < 0 || latitude < 0){
            System.out.println("Input Error on line " + lineNumber + " one of the parameters-> '" + longitude + "', '" + latitude + "'or '" + elevation + "'" + "is < '0'");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        AircraftFactory aircraftFactory = new AircraftFactory();
        boolean noError = true;
        if (args.length != 1) {
            System.out.println("Please provide ONLY a simulation.txt file as args");
            return;
        }
        else {
            try {
                FileReader fileReader = new FileReader(args[0]);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                List<String> lines = new ArrayList<>();
                String line = null;

                lines.add(bufferedReader.readLine());
                try {
                    simCount = Integer.parseInt(lines.get(0));
                }catch (NumberFormatException e){
                    System.out.println("Input Error : please check line 1 -> '" + line + "' This value must be an integer that is more than or equal to one.");
                }
//                System.out.println("The Simulation will run " + simCount + " times.");
                line = bufferedReader.readLine();
                while (line != null) {
                    lines.add(line);
                    line = bufferedReader.readLine();
                }
                for(int i = 1 ; i < lines.size(); i++) {
                    String[] splitLine = lines.get(i).split(" ");
                    if (splitLine.length != 5){
                        System.out.println("Input Error on line " + (i + 1) + ": Needs 5 arguments");
                        System.exit(-1);
                    }
                    try {
                        if (noError = checkline(i, splitLine[0],
                                splitLine[1],
                                Integer.parseInt(splitLine[2]),
                                Integer.parseInt(splitLine[3]),
                                Integer.parseInt(splitLine[4]))) {
                            Flyable aircraft = aircraftFactory.newAircraft(
                                    splitLine[0],
                                    splitLine[1],
                                    Integer.parseInt(splitLine[2]),
                                    Integer.parseInt(splitLine[3]),
                                    Integer.parseInt(splitLine[4]));

                            weatherTower.register(aircraft);
                            aircraft.registerTower(weatherTower);
                        }
                    }catch(NumberFormatException e){
                        System.out.println("Number Format Error : Please check line " + (i + 1) + "the last three values must be integer values that are >= 0");
                    }
                }
                if(noError) {
                    for (int i = 0; i < simCount; i++) {
                        weatherTower.changeWeather();
                    }
                    Writer.printLines();
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
