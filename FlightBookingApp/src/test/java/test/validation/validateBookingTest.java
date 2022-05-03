package test.validation;

import junit.framework.TestCase;
import test.parser.readBookingDetails;
import test.parser.readFlightDetails;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;

import static test.validation.validateBooking.validateCard;

public class validateBookingTest extends TestCase {

    public String InvalidPaymentCard(){
        return "99990000111144445";
    }
    public String ValidPaymentCard(){
        return "4123456789012";
    }

    public void testPaymentCard(){
        assertEquals(validateBooking.validateCard(ValidPaymentCard()),true);
        assertEquals(validateBooking.validateCard(InvalidPaymentCard()),false);
    }

    public void testValidation() throws IOException {
        readBookingDetails validrbd = new readBookingDetails("/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/ValidBooking.csv");
        readFlightDetails validfbd = new readFlightDetails("/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/ValidFlights.csv");
//        readFlightDetails invalidfbd = new readFlightDetails("/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/InvalidFlights.csv");
        String outputPath = "/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.csv";
        String errorPath = "/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.txt";
        validateBooking.validate(validrbd,validfbd,outputPath,errorPath);
        BufferedReader br = new BufferedReader(new FileReader(errorPath));
        assertEquals(br.readLine(),null);
        assertNull(br.readLine());
//        validateBooking.validate(validrbd,invalidfbd,outputPath,errorPath);
//        BufferedReader br = new BufferedReader(new FileReader(errorPath));
//        assertNotNull(br.readLine());
    }

}