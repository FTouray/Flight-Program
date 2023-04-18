
/**
 * New data type called Passenger.
 * Fatoumatta Touray | C21354101
 * 
 */
public class Passenger /**Task 2 - Define passengers*/
{
    /**Task 2.1 - Create standard operation*/
    //1. Data about passenger - Instance variables
    private String name;
    private String address;
    private String emailAddress;
    private Flight flightAddress;
    private String brunch;
    private String dinner;
    private String drink;

    //2. First method - Constructor - create a blank object
    public Passenger()
    {
        this.name =  ""; //refering to an instance variable
        this.address = "";
        this.emailAddress = "";
        this.flightAddress = null;
        this.brunch = null;
        this.dinner = null;
        this.drink = null;
    }

    // Constructor 2 - create a new passenger object who is has not booked a flight
    public Passenger(String name, String address, String emailAddress)
    {
        this.name =  name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.flightAddress = null;
        this.brunch = null;
        this.dinner = null;
        this.drink = null;
    }

    // Constructor 3 - create a new passenger object with data
    public Passenger(String name, String address, String emailAddress, Flight flightAddress)
    {
        this.name =  name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.flightAddress = flightAddress;
    }

    //Constructor 4 - create a new passenger object who have ordered a meal
    public Passenger(String name, String address, String emailAddress, Flight flightAddress, String brunch, String dinner, String drink)
    {
        this.name =  name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.flightAddress = flightAddress;
        this.brunch = brunch;
        this.dinner = dinner;
        this.drink = drink;
    }

    // return the passengers name
    public String getName()
    {
        return this.name;
    }

    // return the passengers address
    public String getAddress()
    {
        return this.address;
    }

    // return the passengers email address
    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public Flight getFlightAddress()
    {
        return this.flightAddress;
    }

    public String getBrunch()
    {
        return this.brunch;
    }

    public String getDinner()
    {
        return this.dinner;
    }

    public String getDrink()
    {
        return this.drink;
    }

    //  update the passengers's name to a new name
    public void setName(String name)
    {
        this.name = name;
    }

    //  update the passengers's address to a new address
    public void setAddress(String address)
    {
        this.address = address;
    }

    //  update the passengers's address to a new address
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setFlightAddress(Flight flight)
    {
        this.flightAddress = flight;
    }

    public void setBrunch(String brunch)
    {
        this.brunch = brunch;
    }

    public void setDinner(String dinner)
    {
        this.dinner = dinner;
    }

    public void setDrink(String drink)
    {
        this.drink = drink;
    }

    //Method/module to display passenger bookings
    public String toString()
    {
        String bookings = null;
        bookings =  "\n\nPasenger name is: " + this.name + "\n" +
        "Passengers address is: " + this.address + "\n" +
        "Passengers email address is: " + this.emailAddress + "\n" +
        "This passenger flight details are: " + this.flightAddress + "\n";
        if (this.brunch == null && this.dinner == null && this.drink == null)
        {
            bookings = bookings + "This passenger has not ordered a meal and drink\n";
        }
        else
        {
            bookings = bookings + "This passenger has ordered " + this.brunch + ", " + this.dinner + " and " + this.drink 
            + " for their flight.";
        }

        return bookings;
    }
    
    //Boolean that returns true if passenger is booked on a flight
    /**Task 2.2 - Calculate if passenger is linked to a flight*/
    public boolean hasFlight()
    {
        boolean hasFlight = true;
        
        if (this.flightAddress == null)
        {
            hasFlight = false;
        }
        else 
        {
            hasFlight = true;
        }
        
        return hasFlight;
    }
    

}