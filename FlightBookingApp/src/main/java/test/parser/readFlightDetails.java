package test.parser;

import test.db.flight;

import java.io.*;
import java.util.*;

public class readFlightDetails {
    // Singleton pattern - Only one instance of the class is created and used.
    public static ArrayList<flight> allFlights;
    public readFlightDetails(String file){
        try {
            allFlights = new ArrayList<flight>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                boolean flightAlreadyInList = false;
                for( flight f : allFlights) {
                    if(f.getFlightNumber().equals(fields[1])) {
                        f.setFullDetails(fields[0],Integer.parseInt(fields[2]),Double.parseDouble(fields[3]));
                        flightAlreadyInList = true;
                    }
                }
                if(!flightAlreadyInList) {
                    flight newFlight = new flight(fields[1],fields[0],Integer.parseInt(fields[2]),Double.parseDouble(fields[3]));
                    allFlights.add(newFlight);
                }

            }

        } catch (Exception e) {
            System.out.println("Error while processing Flight details:" + e);
        }
    }
}
