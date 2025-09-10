class MovieTicket {
    String movieName, theatreName;
    int seatNumber;
    double price;

    MovieTicket() {
        this("Unknown", "NA", 0, 0.0);
    }

    MovieTicket(String movieName) {
        this(movieName, "NA", 0, 200.0);
    }

    MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200.0);
    }

    MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void printTicket() {
        System.out.println("Movie: " + movieName + " | Theatre: " + theatreName + " | Seat: " + seatNumber + " | Price: " + price);
    }
}

public class MovieSystem {
    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Avengers");
        MovieTicket t3 = new MovieTicket("Batman", 12);
        MovieTicket t4 = new MovieTicket("Inception", "IMAX", 5, 400);

        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
