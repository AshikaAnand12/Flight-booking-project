package test.parser;

import junit.framework.TestCase;
import test.db.flight;

import java.util.ArrayList;

public class readFlightDetailsTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }
    public String createValidRecord(){
        return "Economy,SJ456,5,250,Seattle,San Jose";
    }

    public String createInvalidRecord(){
        return "Economy,SJ456,5,2500000000000000000000000000000,Seattle,San Jose";
    }

    public ArrayList<flight> prepareValidRecordForValidateEachRecord(){
        ArrayList<flight> testFlights = new ArrayList<flight>();
        String record = createValidRecord();
        String[] fields = record.split(",");
        flight f = new flight(fields[1],fields[0],Integer.parseInt(fields[2]),Double.parseDouble(fields[3]));
        testFlights.add(f);
        return testFlights;
    }

    public String useValidFilePath(){
        return "/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/ValidFlights.csv";
    }

    public String useInvalidFilePath(){
        return "/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/InvalidFlights.csv";
    }

    public ArrayList<flight> prepareInvalidRecordForValidateEachRecord(){
        ArrayList<flight> testFlights = new ArrayList<flight>();
        String record = createValidRecord();
        String[] fields = record.split(",");
        flight f = new flight(fields[1],fields[0],Integer.parseInt(fields[2]), (double) Long.parseLong(fields[3]));
        testFlights.add(f);
        return testFlights;
    }


    public  void testvalidateflightdetails(){
        String path = useValidFilePath();
        readFlightDetails flight = new readFlightDetails(path);
        assertEquals(flight.allFlights.get(0).getFlightNumber(),prepareValidRecordForValidateEachRecord().get(0).getFlightNumber());
    }
}