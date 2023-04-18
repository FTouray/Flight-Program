import java.util.Scanner;
import java.util.ArrayList;
/**
 * FlightDriver class.
 *
 * Fatoumatta Touray | C21354101
 */
public class FlightDriver
{
    //Global variables - variables that will be used throught the whole program.
    ArrayList<Flight>flightDetails; //Declaring an ArrayList for the flights - this is where the info will be stored
    final int NUMBER_FLIGHTS = 5; //Number of flights that will be made

    ArrayList<Passenger>passengerBookings; //Declaring an ArrayList for where the passengers details will be stored

    //Constructor to call all the methods
    public FlightDriver()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("/f"); //to clear the screen 

        //Have to create a blank passenger ArrayList
        passengerBookings = new ArrayList<Passenger>();

        //Have to create the flight ArrayList with 5 flights
        flightDetails = new ArrayList<Flight>();

        //Calling createFlights method
        createFlights();

        //Display menu options
        displayMenu();
    }

    //Hardwired Flights - make it easier to run and test the programme
    /**public void createFlights()
    {
    Scanner scan = new Scanner(System.in);
    Flight aFlight;

    aFlight = new Flight("EI111", "Monday", "Amsterdam", 0);
    flightDetails.add(aFlight);

    aFlight = new Flight("EI222", "Friday", "Milan", 0);
    flightDetails.add(aFlight);

    aFlight = new Flight("EI333", "Wednesday", "Athens", 0);
    flightDetails.add(aFlight);

    aFlight = new Flight("EI444", "Sunday", "Munich", 0);
    flightDetails.add(aFlight);

    aFlight = new Flight("EI555", "Saturday", "New York City", 0);
    flightDetails.add(aFlight);

    }*/

    //Creating Flights - user inputs the flight details
    public void createFlights()
    {
        Scanner scan = new Scanner(System.in);
        Flight aFlight;
        System.out.print("\f");

        String flightNumber;
        String dayOfFlight;
        String destination;
        int seatsBooked = 0; //initialising variable to 0

        /**Task 3 - Input details about 5 flights*/
        System.out.println("Create " + NUMBER_FLIGHTS + " flights");
        System.out.println("\nFlight number should start with the letters 'E' & 'I' followed by three numbers (EI000)");
        System.out.println("Day of travel should be a day of the week (Monday)");
        System.out.println("Destination should be a city (Dubai)");

        for (int count = 0; count < NUMBER_FLIGHTS; count++)
        {

            do
            {

                /**Task 3.1 - Input flight number*/
                System.out.println("\nEnter flight number for flight " + (count + 1));
                flightNumber = scan.nextLine();
                /**Task 3.1.1 - Validate flight number*/
                duplicateFlightNumber(flightNumber);

                if (!flightNumber.matches("EI[0-9]{3}"))
                {
                    System.out.println("Incorrect flight number, it must start with EI, followed by three numbers try again!");
                }
            }while  (!flightNumber.matches("EI[0-9]{3}"));

            do
            {
                /**Task 3.2 - Input day flight leaves*/
                System.out.println("Enter day flight "+ (count + 1) + " leaves");
                dayOfFlight = scan.nextLine();
                if (!dayOfFlight.equals("Monday") && !dayOfFlight.equalsIgnoreCase("Tuesday") && !dayOfFlight.equals("Wednesday") &&
                !dayOfFlight.equals("Thursday") && !dayOfFlight.equals("Friday") && !dayOfFlight.equals("Saturday") &&
                !dayOfFlight.equals("Sunday"))
                {
                    System.out.println("Please enter a day of the week\n");
                }
            }while (!dayOfFlight.equals("Monday") && !dayOfFlight.equalsIgnoreCase("Tuesday") && !dayOfFlight.equals("Wednesday") &&
            !dayOfFlight.equals("Thursday") && !dayOfFlight.equals("Friday") && !dayOfFlight.equals("Saturday") &&
            !dayOfFlight.equals("Sunday"));

            /**Task 3.3 - Input destination of flight*/
            System.out.println("Enter destination of flight " + (count + 1));
            destination = scan.nextLine();

            aFlight = new Flight(flightNumber, dayOfFlight, destination, seatsBooked);
            flightDetails.add(aFlight);
        }
    }

    public void duplicateFlightNumber(String flightNumber)
    {
        //keep them trapped in a loop if flight number is already in flight number
        Scanner scan = new Scanner(System.in);

        boolean found = false;

        do
        {
            found = false; 

            for (Flight f : flightDetails)
            {

                if (flightNumber.equalsIgnoreCase(f.getFlightNumber())) 
                {    
                    found = true;
                }

            }

            if (found == true)
            {
                System.out.println("Flight number already entered. ");
                System.out.println("\nPlease enter flight number!");
                flightNumber = scan.nextLine();
            }
        }while (found == true);
    }

    public void displayMenu()
    {
        System.out.print("\f"); //clear the screen of the flights being made
        Scanner scan = new Scanner(System.in);
        String menu; //local variable for this method - declared as String so program doesn't crash if wrong data type is inputted

        do
        {
            /**Task 4.1 - Displaying menu option*/
            System.out.print("\f");
            System.out.println("\t\tWelcome LUXURY AIRLINES. Choose a menu option");
            System.out.println("\n1. Book a flight");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Display full flight schedule");
            System.out.println("4. Display passenger booking");
            System.out.println("5. Order passenger meal");
            System.out.println("6. Exit system");

            do
            {
                System.out.println("Enter menu option that you wish to carry out");
                menu = scan.nextLine();
                //validating menu option 
                if ((menu.charAt(0) != '1') && (menu.charAt(0) != '2') && (menu.charAt(0) != '3') && (menu.charAt(0) != '4') && (menu.charAt(0) != '5') && (menu.charAt(0) != '6'))
                {
                    System.out.println("Error - option should be 1, 2, 3, 4, 5 or 6. Try again");
                }/**Task 4.2 - Repeat from Task 4.1 if option menu is invalid*/
            }while ((menu.charAt(0) != '1') && (menu.charAt(0) != '2') && (menu.charAt(0) != '3') && (menu.charAt(0) != '4') && (menu.charAt(0) != '5') && (menu.charAt(0) != '6'));

            if (menu.charAt(0) == '1')/**Task 5 - If menu option is 1*/
            {
                bookFlight(); //calling the bookFlight method if menu is 1
            }
            else
            if (menu.charAt(0) == '2')/**Task 6 - If menu option is 2*/
            {
                cancelBooking(); //calling the cancelBooking method if menu is 2
            }
            else
            if (menu.charAt(0) == '3')/**Task 7 - If menu option is 3*/
            {
                displaySchedule(); //calling the displaySchedule method if menu is 3
            }
            else
            if (menu.charAt(0) == '4')/**Task 8 - If menu option is 4*/
            {
                displayBookings();
            }
            else
            if (menu.charAt(0) == '5')/**Task 9 - If menu option is 5*/
            {
                orderFood();
            }

            System.out.println("\nPress return to continue");
            scan.nextLine();
            /**Task 5.2.2.2 - Return to menu.*/
        }while (menu.charAt(0) != '6'); 

        if (menu.charAt(0) == '6') /**Task 10 - If menu option is 6*/
        {
            /**Task 10.1 - Exit program*/
            System.out.print("\f");
            System.out.println("Exiting Program"); 
        }

    }

    //Menu option 1 - book a flight
    public void bookFlight()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);
        String dest, day;
        boolean found = false;
        // int seatsBooked - I was getting an error until I realised that I need the round brackets after the get.SeatsBooked

        /**Task 5.1 - Input details of flight that is wanted*/
        //Ask user to input destination & day of flight
        System.out.print("BOOKING A FLIGHT");
        /**Task 5.1.1 - Ask user to input destination*/
        System.out.println("\nEnter ther city of destination you wish to travel to:"); 
        dest = scan.nextLine();
        /**Task 5.1.2 - Ask user to input day*/
        System.out.println("Enter the day of the week that the flight leaves:"); 
        day = scan.nextLine();

        //Have to search the flight ArrayList to see if this type of flight Exists
        for (Flight f : flightDetails)
        {
            /**Task 5.2 - Verify details of flight that is wanted*/
            if (dest.equalsIgnoreCase(f.getDestination()) && day.equalsIgnoreCase(f.getDayOfFlight()) && f.seatsAvailable() > 0) 
            /*if destination and day inputted is the same as destination and day in the flight
            ArrayList then seat is booked and they will be asked to input their details*/
            {                
                found = true;
                System.out.println("Flight found. Enter passenger details");
                /**Task 5.2.1 - Make passenger booking if flight is available*/
                passengerDetails(f);

                //Have to search the passenger to list in order to change the flight variable.
                //Have to put if statement here because the detination and day variable are already delcared.
            }

        }

        if (!found)
        {
            System.out.println("\nFlight not available. Seats may be fully booked");
            /**Task 5.2.2.1 - Display other flights that may be chosen.*/
            alternative(); 
        }

    }

    public void alternative() //Display alternative if flight details inputted is not a flight or can't be found..
    {   
        System.out.println("\n\nDISPLAYING ALTERNATIVE FLIGHTS....\n");
        for (Flight f : flightDetails)
        {
            System.out.println(f.displayFlights());
        }
    }

    //Passenger details so that method for booking a flight is not to long
    public void passengerDetails(Flight f)
    {
        Scanner scan = new Scanner(System.in);
        String name, address, emailAddress; //local variables for the passengerDetails method
        Passenger passenger1;

        //Ask user to input the info needed for passenger bookings - name, address and email
        /**Task 5.2.1.1 - Ask user to input passenger name*/
        System.out.print("\nEnter passenger name: ");
        name = scan.nextLine();
        /**Task 5.2.1.2 - Ask user to input passenger address*/
        System.out.print("Enter passengers address: ");
        address = scan.nextLine();
        /**Task 5.2.1.3 - Ask user to input passenger email address*/
        System.out.print("Enter passengers email address: ");
        emailAddress = scan.nextLine();

        //Creating a passenger object
        passenger1 = new Passenger(name, address, emailAddress, f);
        //have to add this to passenger 1
        passengerBookings.add(passenger1);

        /*I want to put an if statement here saying that if the destination and day inputted are the same as a flight
        to set the flightNumber variable of the passenger to that particular flight. Not sure whether to put it here
        or after I call the passengerDetails() method.-not needed*/

        /*for each flight that has a passenger booked increase booked by 1*/
        int booked = 0;
        for (Passenger p : passengerBookings)
        {
            /**Task 5.2.1.4 - Display booking details*/
            if (p.getFlightAddress().getFlightNumber().equals(f.getFlightNumber()))
            {
                /**Task 5.2.1.5 - Increase passenger booking by 1*/
                booked++;
                //booked = p.getFlightAddress().getSeatsBooked() + 1;
                p.getFlightAddress().setSeatsBooked(booked); 

                /**Task 5.2.1.4 - Display booking details*/
                System.out.println("\n\nA seat has been booked for " + name + " on flight " + p.getFlightAddress().getFlightNumber());

            }
        }

    }

    //Increment the number of seats by one if seat is booked.
    //Menu option 2 - cancel a booking
    public void cancelBooking()
    {
        System.out.print("\f");
        boolean found = false;
        Scanner scan = new Scanner(System.in);
        String nameOfPassenger;
        String flightNum;

        System.out.println("BOOKING CANCELLATION");
        /**Task 6.1.1 - Ask user to input passenger name*/
        System.out.print("\n\nEnter name of passenger whose booking is being cancel: ");
        nameOfPassenger = scan.nextLine();
        /**Task 6.1.2 - Ask user to input passenger flight number*/
        System.out.print("Enter the flight number the passenger is  currently booked on: ");
        flightNum = scan.nextLine();

        /**Task 6.1 - Search passenger booking list*/
        for (Passenger p : passengerBookings) //search the passenger ArrayList to see if name and flight number matches a passenger
        {
            if (nameOfPassenger.equalsIgnoreCase(p.getName()) && flightNum.equals(p.getFlightAddress().getFlightNumber())) //searches the passenger list and if flight num equals to the flight number in the flight address
            {
                /**Task 6.3 - Increase seats available by 1*/
                int booked = 0;
                found = true;
                //booked--;
                booked = p.getFlightAddress().getSeatsBooked() - 1;
                p.getFlightAddress().setSeatsBooked(booked); 
                System.out.println("\nSeat is now available on flight " + p.getFlightAddress().getFlightNumber());

                System.out.println("\nBooking has been cancelled");
                /**Task 6.2 - Set passenger flight address variable to null*/
                p.setFlightAddress(null);

            }
        }  

        if (passengerBookings.isEmpty())
        {
            System.out.println("\nNo bookings have been made. ");
        }
        else if (!found)
        {
            System.out.println("\nName or flight number is incorrect or passenger does not exist in the file system.");
            System.out.println("Cancellation is unsuccessful.");
        }
    }

    //Menu option 3 - display full flight schedule
    public void displaySchedule()
    {
        System.out.print("\f");
        System.out.println("\n\nDISPLAYING ALL FLIGHT SCHEDULES....\n");
        for (Flight f : flightDetails)
        {
            /**Task 7.1 - Display all flight details*/
            System.out.println(f.toString());
        }
    }

    //Menu option 4 - display passenger booking
    public void displayBookings()
    {
        System.out.print("\f");
        System.out.println("\n\nDISPLAYING ALL BOOKINGS....\n");
        boolean hasFlight = true;

        for (Passenger p : passengerBookings)
        {
            if (p.hasFlight())/**Task 8.1 - Display passengers that have a booking*/
            {
                System.out.println(p.toString()); 
            }
        }
    }

    //Menu option 5 - food menu
    public void orderFood()
    {
        System.out.print("\f");
        System.out.println("ORDER FOOD & DRINKS....\n");
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        String nameOfPassenger;
        String flightNum;
        String brunch;
        String dinner;
        String drink;

        /**Task 9.1 - Ask user to input name and flight number of passengers*/
        System.out.print("\nEnter name of passenger that is ordering: ");
        nameOfPassenger = scan.nextLine();
        System.out.print("Enter the passenger's flight number: ");
        flightNum = scan.nextLine();

        for (Passenger p : passengerBookings) //search passenger ArrayList for passenger
        {
            if (nameOfPassenger.equalsIgnoreCase(p.getName()) && flightNum.equals(p.getFlightAddress().getFlightNumber())) 
            //searches the passenger list and if flight num equals to the flight number in the flight address
            {
                found = true;
                /**Task 9.1.1 - Display food menu*/
                System.out.println("\tMENU");
                do
                {
                    /**Task 9.1.1.1 - Input brunch option*/
                    System.out.println("\n\nBRUNCH MENU\n");
                    System.out.println("\tFrench Toast" + "\n" + "\tScrambled Eggs" + "\n" + "\tWaffles");
                    System.out.println("\nPlease choose one of the brunch options above");
                    brunch = scan.nextLine();
                    //validating menu option 
                    if (!brunch.equalsIgnoreCase("French Toast") && !brunch.equalsIgnoreCase("Scrambled Eggs") && !brunch.equalsIgnoreCase("Waffles"))
                    {
                        System.out.println("Error - not an option. Apologises for any inconvience");
                    }
                    p.setBrunch(brunch);
                }while (!brunch.equalsIgnoreCase("French Toast") && !brunch.equalsIgnoreCase("Scrambled Eggs") && !brunch.equalsIgnoreCase("Waffles"));

                do
                {
                    /**Task 9.1.1.1 - Input dinner option*/
                    System.out.println("\n\nDINNER MENU\n");
                    System.out.println("\tCurry Chicken" + "\n" + "\tLasagna" + "\n" + "\tRavioli");
                    System.out.println("\nPlease choose one of the dinner options above");
                    dinner = scan.nextLine();
                    //validating menu option 
                    if (!dinner.equalsIgnoreCase("Curry Chicken") && !dinner.equalsIgnoreCase("Lasagna") && !dinner.equalsIgnoreCase("Ravioli"))
                    {
                        System.out.println("Error - not an option. Apologises for any inconvience");
                    }
                    p.setDinner(dinner);
                }while (!dinner.equalsIgnoreCase("Curry Chicken") && !dinner.equalsIgnoreCase("Lasagna") && !dinner.equalsIgnoreCase("Ravioli"));

                do
                {
                    /**Task 9.1.1.2 - Input drink option*/
                    System.out.println("\n\nDRINK MENU\n");
                    System.out.println("\tWater" + "\n" + "\tRed Wine" + "\n" + "\tApple Juice");
                    System.out.println("\nPlease choose one of the drink options above");
                    drink = scan.nextLine();
                    //validating menu option 
                    if (!drink.equalsIgnoreCase("Water") && !drink.equalsIgnoreCase("Red Wine") && !drink.equalsIgnoreCase("Apple Juice"))
                    {
                        System.out.println("Error - not an option. Apologises for any inconvience");
                    }
                    p.setDrink(drink);
                }while (!drink.equalsIgnoreCase("Water") && !drink.equalsIgnoreCase("Red Wine") && !drink.equalsIgnoreCase("Apple Juice"));

                System.out.print("\n" + brunch + " for brunch, " + dinner + " for dinner and " + drink + " has ordered by " + p.getName()); 

            }
        }

        if (!found)
        {
            /**Task 9.2 - Display message if passenger is not found or does not have a booking. */
            System.out.println("\nPassenger name or flight number is be incorrect");
            System.out.println("Food cannot be ordered.");
        }
    }

    public static void main(String[] args){
        new FlightDriver();
    } // end main
}
