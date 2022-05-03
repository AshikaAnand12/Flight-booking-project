# Individual Project


## Steps to Execute
Few steps to execute the project are as follows:
1. Navigate to the project directory
2. Execute following commands:     
`mvn compile `   
`mvn clean install`    
To run the project, enter path of the input files and output files - my input was stored in say: “/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/Sample.csv” 
In the FlightBookingApp(project), in the root directory, there is an input folder where the input files can be stored
Same for the output files as well:
Example: “/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.csv”
`mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args=
"/Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/Sample.csv /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/input/flights.csv /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.csv /Users/ashika/Downloads/FlightBookingApp/src/main/java/test/output/Output.txt"`
Where: args[0] - Path to Bookings csv, 
args[1] - Path to Flights csv, 
args[2] - Path to Output csv and 
args[3] - Path to error txt files


## Primary Problem
The primary problem I tried to solve is booking flights. There are various methods on how the data can be stored and accessed such as just creating a list of objects for both flights and booking data and then comparing each object in that booking to each object of flight and then validating the price, seats and category for each booking as per requirements. This is a tedious, time consuming and inefficient process.
 
We can also create a hashmap of flight to map each flight to its category but again it’s an inefficient design as the mapping doesn’t track the seats and price per seat. It has to be validated again or we need to create a hashmap of hashmap. 

The most simple, efficient and valid design is to create a subclass for the flight with category, price and number of seats in each flight. This can be used to map flight to its other features (category,seats and price per seat), when booking’s flight number is validated against flight’s flight number, it automatically retrieves all categories that are associated with the flight and when the category is validated, it just has to validate if within subclass there is a category that is same as that of booking and then use the details w.r.t to that category to get number of seats and price.

## Secondary Problem
Secondary problem is validating all details and managing status. To validate a card number,  first I need to validate if all of the booking details entered are correct. I have used enum to manage status if the flight number is valid, change status to validFlight, if category is validated, status changed to validCategory and so on. If all the conditions are met, the status is changed to success and output csv is populated, else if any of the conditions is not met, then entry into the error file with reason is added.

## Design Pattern
Three design patterns I have used is: 
### Singleton
Singleton design pattern is used when the system has to ensure that only one instance of the class is created. I have stored flight information as static and created a single instance of the object which is accessed throughout the code.


### Chain of Responsibility
Chain of responsibility pattern is used when a set of objects handle the quest with a handler. On running the project, at first an object of flight is created, then an object of booking is created, both these objects are passed to the validation where the details are validated against each other and then entered into output or error files.


### Composite
Composite design pattern is used where hierarchical representation of objects is required. Class Flight has subclass categoryAndSeats. 

## Consequences of using a design pattern
By using a singleton pattern, data is clean and only one instance of data is required which is created and used. 
Using chain of responsibility we have a client called RunClient which has an interface to validate handler functions in the validation package where the function internally handles with 2 other objects of flight and booking.
Using a composite design pattern we have created a scalable and efficient access control to the data within the flight. The class flight facilitates the subclass categoryAndSeats and the objects of subclass are nested within the objects of flight class. 
