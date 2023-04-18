
/**
 * Defintion for a Flight
 *Fatoumatta Touray | C21354101
 * 
 */
public class Flight /**Task 1 - Define flight*/
{
    /**Task 1.1 - Create standard operations*/
    private String flightNumber; //common variable between flight class and passenger class
    private String dayOfFlight;
    private String destination;
    private int seatsBooked;

    public Flight()
    {
        this.flightNumber = "";
        this.dayOfFlight = "";
        this.destination = "";
        this.seatsBooked = 0;
    }

    public Flight(String flightNumber, String dayOfFlight, String destination, int seatsBooked)
    {
        this.flightNumber = flightNumber;
        this.dayOfFlight = dayOfFlight;
        this.destination = destination;
        this.seatsBooked = 0;
    }

    public String getFlightNumber()
    {
        return this.flightNumber;
    }

    public String getDayOfFlight()
    {
        return this.dayOfFlight;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public int getSeatsBooked()
    {
        return this.seatsBooked;
    }

    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public void setDayOfFlight(String dayOfFlight)
    {
        this.dayOfFlight = dayOfFlight;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public void setSeatsBooked(int seatsBooked)
    {
        this.seatsBooked = seatsBooked;
    }

    //Calculate how many seats available
    /**Task 1.2 - Calculate number of seats*/
    public int seatsAvailable()
    {
        int seatsAvailable = 10;

        seatsAvailable = seatsAvailable - this.seatsBooked;

        return seatsAvailable;
    }

    public String displayFlights()
    {
        return "\nFlight number is " + this.flightNumber + "\n" + 
        "Flight leaves on " + this.dayOfFlight + "\n" + 
        "Destination of this flight is " + this.destination;
    }

    public String toString()
    {
        return "\nFlight number is " + this.flightNumber + "\n" + 
        "Flight leaves on " + this.dayOfFlight + "\n" + 
        "The final destination of this flight is " + this.destination + "\n" + 
        "There is " + this.seatsBooked + " seats booked " + "\n" +
        "There is " + seatsAvailable() + " seats available on this flight.";

    }

}
