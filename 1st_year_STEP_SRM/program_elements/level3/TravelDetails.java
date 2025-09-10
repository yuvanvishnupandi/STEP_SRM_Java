import java.util.Scanner;
 
public class TravelDetails {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter your name: ");
    	String name = scanner.nextLine();
    	System.out.print("Enter your departure city: ");
    	String fromCity = scanner.nextLine();
    	
    	System.out.print("Enter the via city: ");
    	String viaCity = scanner.nextLine();
    	
    	System.out.print("Enter your destination city: ");
    	String toCity = scanner.nextLine();
    	
    	System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
    	double fromToVia = scanner.nextDouble();
    	
    	System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
    	double viaToFinalCity = scanner.nextDouble();
    	
    	System.out.print("Enter the total travel time in hours: ");
    	double travelTime = scanner.nextDouble();
    	
    	double totalDistance = fromToVia + viaToFinalCity;
    	double averageSpeed = totalDistance / travelTime;
    	
    	System.out.println("Traveler: " + name);
    	System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
    	System.out.println("Total Distance: " + totalDistance + " miles");
    	System.out.println("Average Speed: " + averageSpeed + " miles per hour");
    	
    	scanner.close();
    }}
