package test.db;

import java.util.ArrayList;

public class flight {
    public flight(String name, String category, Integer seats, Double price) {
        this.setFlightNumber(name);
        this.fullDetails = new ArrayList<>();
        this.setFullDetails(category, seats, price);
    }

    public enum Category {

        ECONOMY("Economy"), PREMIUMECONOMY("Premium Economy"), BUSINESS("Business");

        Category(String label) {
            this.label = label;
        }

        public String label;

        public String getLabel() {
            return label;
        }

        public static Category stringToCategory(String type)
        {
            for(Category tempCategory : Category.values())
                if(tempCategory.getLabel().equals(type)) {
                    return tempCategory;
                }
            return null; //not found
        }
    }

    // Composite
    public class categoryAndSeats {
        public categoryAndSeats(Category type, Integer seats, Double price) {
            this.type = type;
            this.numSeats = seats;
            this.pricePerSeat = price;
        }
        public Category type;
        public Integer  numSeats;
        public Double  pricePerSeat;
    }

    public ArrayList<categoryAndSeats> getFullDetails() {
        return fullDetails;
    }

    public void setFullDetails(ArrayList<categoryAndSeats> fullDetails) {
        this.fullDetails = fullDetails;
    }


    public void setFullDetails(String type, Integer numSeats, Double price) {
        boolean alreadyExists = false;
        for(categoryAndSeats item : fullDetails) {
            if(item.type.getLabel() == type) {
                alreadyExists = true;
            }
        }
        if(!alreadyExists) {
            fullDetails.add(new categoryAndSeats(Category.stringToCategory(type),numSeats,price));
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    private String flightNumber;
    private ArrayList<categoryAndSeats> fullDetails;
}
