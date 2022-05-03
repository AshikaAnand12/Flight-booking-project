package test.validation;


import test.db.bookingDetails;
import test.db.flight;
import test.db.flight.Category;
import test.db.flight.categoryAndSeats;
import test.parser.readBookingDetails;
import test.parser.readFlightDetails;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class validateBooking {

    enum Status {
        Invalid, ValidFlight, ValidCategory, ValidSeats, Success
    }

    public  static void validate(readBookingDetails rbd,readFlightDetails fbd, String pathToOutput, String pathToError) throws IOException {
        String invalidEntry="";
        String validEntry  ="Booking Name, Flight Number, Category,  Number of Seats Booked, Total Price\n";

        for(bookingDetails bd: rbd.allBookings){
            Status status = Status.Invalid;
            double ticketPrice = 0;
            for(flight f: fbd.allFlights){
                if(bd.getFlightNumber().equals(f.getFlightNumber())){
                    status = Status.ValidFlight;
                    for(categoryAndSeats cs : f.getFullDetails()) {
                        if(cs.type == Category.stringToCategory(bd.getSeatCategory())) {
                            status = Status.ValidCategory;
                            if(bd.getNumSeats() <= cs.numSeats) {
                                status = Status.ValidSeats;
                                cs.numSeats -= bd.getNumSeats();
                                boolean isValid = false;
                                isValid = validateCard(bd.getPaymentCard());
                                if(isValid) {
                                    status = Status.Success;
                                    ticketPrice = bd.getNumSeats() * cs.pricePerSeat;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
            switch (status) {
                case Invalid: invalidEntry+= ("Please enter correct booking details for "+bd.getUserName()+": invalid flight number : "+bd.getFlightNumber()+"\n");
                break;
                case ValidFlight: invalidEntry+= ("Please enter correct booking details for "+bd.getUserName()+": invalid category : "+bd.getSeatCategory()+"\n");
                break;
                case ValidCategory: invalidEntry+= ("Please enter correct booking details for "+bd.getUserName()+": not enough seats : "+bd.getNumSeats()+"\n");
                break;
                case ValidSeats: invalidEntry+= ("Please enter correct booking details for "+bd.getUserName()+": invalid card number : "+bd.getPaymentCard()+"\n");
                break;
                case Success: validEntry += bd.getUserName()+","+bd.getFlightNumber()+","+bd.getSeatCategory()+","+bd.getNumSeats()+","+ticketPrice+"\n";
            }
        }
        populateErrorFile(invalidEntry, pathToError);
        populateOutputFile(validEntry, pathToOutput);
    }

    public static boolean validateCard(String card) {
        char secondLetter = card.charAt(1);
        if ((card.startsWith("4") && ((card.length() == 13) || (card.length() == 16)))
                || (card.startsWith("5") && (card.length() == 16) && ((secondLetter == '1') || (secondLetter == '2') || (secondLetter == '3') || (secondLetter == '4') || (secondLetter == '5')))
                || (card.startsWith("6011") && (card.length() == 16))
                || (card.startsWith("3") && (card.length() == 15) && ((secondLetter == '4') || (secondLetter == '7')))
        ) {
            return true;
        }
        return false;
    }

    private static void populateOutputFile(String ValidEntry, String pathToOutput) throws IOException {
        Files.writeString(Paths.get(pathToOutput), ValidEntry);
    }
    private static void populateErrorFile(String invalidEntry, String pathToError) throws IOException {
        Files.writeString(Paths.get(pathToError), invalidEntry);
    }
}
