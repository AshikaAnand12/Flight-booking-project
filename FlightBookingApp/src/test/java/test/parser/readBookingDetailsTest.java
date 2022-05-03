package test.parser;

import junit.framework.TestCase;
import test.db.bookingDetails;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class readBookingDetailsTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public String createValidRecord(){
        return "Sam,SJ456,Economy,2,5410000000000000";
    }

    public ArrayList<bookingDetails> prepareValidRecordForValidateEachRecord(){
        ArrayList<bookingDetails> testBookings = new ArrayList<bookingDetails>();
        bookingDetails book = new bookingDetails();
        book.setSeatCategory("Economy");
        book.setUserName("Sam");
        book.setNumSeats(2);
        book.setFlightNumber("SJ456");
        book.setPaymentCard("5410000000000000");
        testBookings.add(book);
        return testBookings;
    }

    public String useValidFilePath(){
        return "/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/ValidBooking.csv";
    }
    public String useInvalidFilePath(){
        return "/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/testing/InvalidBooking.csv";
    }

    public ArrayList<bookingDetails> prepareInvalidRecordForValidateEachRecord(){
        ArrayList<bookingDetails> testBookings = null;
        bookingDetails book = new bookingDetails();
        book.setSeatCategory("Economy");
        book.setUserName("Sam");
        book.setNumSeats(2);
        book.setFlightNumber("SJ456");
        book.setPaymentCard("9990000000000000");
        testBookings.add(book);
        return testBookings;
    }

    public void testvalidateRecord(){
        String path = useValidFilePath();
        readBookingDetails booking = new readBookingDetails(path);
        assertEquals(booking.allBookings.get(0).getConcatenatedFullString(), createValidRecord());
        ArrayList<bookingDetails> assertion = prepareValidRecordForValidateEachRecord();
        assertEquals(booking.allBookings.get(0).getUserName(),assertion.get(0).getUserName());
    }

    public  void testvalidatebookingdetails(){
        String path = useValidFilePath();
        readBookingDetails booking = new readBookingDetails(path);
        ArrayList<bookingDetails> assertion = prepareValidRecordForValidateEachRecord();
        assertEquals(booking.allBookings.get(0).getUserName(),assertion.get(0).getUserName());
        assertEquals(booking.allBookings.get(0).getFlightNumber(),assertion.get(0).getFlightNumber());
        assertEquals(booking.allBookings.get(0).getSeatCategory(),assertion.get(0).getSeatCategory());
        assertEquals(booking.allBookings.get(0).getNumSeats(),assertion.get(0).getNumSeats());
        assertEquals(booking.allBookings.get(0).getPaymentCard(),assertion.get(0).getPaymentCard());

    }
}