package test.parser;

import test.db.bookingDetails;

import java.io.*;
import java.util.*;
public class readBookingDetails {
    public  ArrayList<bookingDetails> allBookings = null;
    public readBookingDetails(String file){
        try {
            allBookings = new ArrayList<bookingDetails>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                bookingDetails output = readBookingFile(line);
                allBookings.add(output);
            }
        } catch (Exception e) {
            System.out.println("Error while processing Booking details:" + e);
        }
    }

    public static bookingDetails readBookingFile(String record) throws IOException {
        String[] fields = record.split(",");
        bookingDetails booking  = new bookingDetails();
        booking.setUserName(fields[0]);
        booking.setFlightNumber(fields[1]);
        booking.setSeatCategory(fields[2]);
        booking.setNumSeats(Integer.parseInt(fields[3]));
        booking.setPaymentCard((fields[4]));
        return booking;
    }
}
