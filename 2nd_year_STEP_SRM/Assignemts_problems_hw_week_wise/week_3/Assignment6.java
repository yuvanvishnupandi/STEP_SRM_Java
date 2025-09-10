// Assignment 6: Flight Booking System
class Flight {
    private String flightId;
    private String destination;
    private int totalSeats;
    private int bookedSeats;
    private static int flightCounter = 0;

    public Flight(String destination, int totalSeats) {
        this.flightId = generateFlightId();
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    private static String generateFlightId() {
        return "FL" + (++flightCounter);
    }

    public boolean bookSeat() {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    public void displayFlightInfo() {
        System.out.println("Flight ID: " + flightId + ", Destination: " + destination +
                ", Seats: " + bookedSeats + "/" + totalSeats);
    }
}

class Passenger {
    private String passengerId;
    private String name;
    private static int passengerCounter = 0;

    public Passenger(String name) {
        this.passengerId = generatePassengerId();
        this.name = name;
    }

    private static String generatePassengerId() {
        return "PSG" + (++passengerCounter);
    }

    public void bookFlight(Flight flight) {
        if (flight.bookSeat()) {
            System.out.println(name + " booked flight " + flight);
        } else {
            System.out.println("No seats available for " + name);
        }
    }
}

public class Assignment6 {
    public static void main(String[] args) {
        Flight f1 = new Flight("New York", 2);
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Bob");
        Passenger p3 = new Passenger("Charlie");

        p1.bookFlight(f1);
        p2.bookFlight(f1);
        p3.bookFlight(f1);

        f1.displayFlightInfo();
    }
}
