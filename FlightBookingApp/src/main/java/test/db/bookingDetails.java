package test.db;

public class bookingDetails {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }
    private String userName;
    private int numSeats;

    public void setPaymentCard(String paymentCard) {
        this.paymentCard = paymentCard;
    }

    public String getPaymentCard() {
        return paymentCard;
    }

    public String getConcatenatedFullString() {
        return userName + ',' + flightNumber + ',' + seatCategory + ',' + numSeats + ',' + paymentCard;
    }

    private String paymentCard;
    private String flightNumber;

    private String seatCategory;
}