class TravelComputation {
    public static void main(String[] args) {
        String name = "Eric";
        String fromCity = "Chennai", viaCity = "Vellore", toCity = "Bangalore";
        double distanceFromToVia = 156.6;
        int timeFromToVia = 4 * 60 + 4;
        double distanceViaToFinalCity = 211.8;
        int timeViaToFinalCity = 4 * 60 + 25;
        
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;
        
        System.out.println("The Total Distance travelled by " + name + " from " +
                           fromCity + " to " + toCity + " via " + viaCity +
                           " is " + totalDistance + " km and " +
                           "the Total Time taken is " + totalTime + " minutes");
    }
}
