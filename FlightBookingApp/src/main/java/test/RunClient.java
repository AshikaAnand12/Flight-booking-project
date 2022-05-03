package test;

import test.parser.readBookingDetails;
import test.parser.readFlightDetails;
import test.validation.validateBooking;

import java.io.IOException;

// Chain of Responsibility
// Read booking data - Control to booking object
// Read flight data - Control to flight object
// Validate Booking - Control to Validate handler in RunClient
// Populate Output and error csv - Get output
public class RunClient {
    public static void main(String[] args) throws IOException {
        readBookingDetails rbd = new readBookingDetails(args[0]);
        readFlightDetails fbd = new readFlightDetails(args[1]);
        validateBooking.validate(rbd,fbd,args[2],args[3]);
    }
}

// Arguments
// 0       /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/Sample.csv
// 1       /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/flights.csv
// 2       /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.csv
// 3       /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.txt


//Command
//mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/Sample.csv /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/flights.csv /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.csv /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.txt"