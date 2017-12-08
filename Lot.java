/**
 * This class maintains data about a lot. It contains an array of spots used 
 * to represents the parking spots in the lot. 
 * @author Quinn
 */
public class Lot {
    private ParkingSpot spot[];
    private int avalibleSpots, lotNum, numMopedSpots, avalibleMopedSpots;
    static int index = 0;
    /**
     * Default constructor. For testing only. 
     */
    public Lot(){
        avalibleSpots = 10;
        spot = new ParkingSpot[10];
        lotNum = 0;
        for(int i=0; i<10; i++)
        {
            spot[i] = new ParkingSpot(i, false);
        }
    }
    /**
     * This constructor takes in a number of normal car spots, the number
     * of moped spots and the designated lot number. It then initializes the
     * parking spots based on their type.
     * @param spots Number of normal parking spots
     * @param numMoped Number of Moped spots
     */
    public Lot( int spots, int numMoped){
        lotNum = index++;
        avalibleSpots = spots;
        avalibleMopedSpots = numMoped;
        spot = new ParkingSpot[spots + numMoped];
        for(int i=0; i<spots; i++)
        {
            spot[i] = new ParkingSpot(i, false);
        }
        for(int i=spots; i<(spots+numMoped); i++)
        {
            spot[i] = new ParkingSpot(i, true);
        }
    }
    /**
     * This method checks through the array of spots for the first one that is
     * open. If a spot is found it is reserved and the spot number is returned.
     * If no open spot is found -1 is returned. 
     * @param car Vehicle the spot will be reserved for.
     * @return The number of the spot occupied or -1 if failed to find a spot.
     */
    public int reserveSpot(Vehicle car){
        boolean spotFound = false;
        int spotNum = 0;
        while(!spotFound && spotNum < (spot.length))
            spotFound = spot[spotNum++].reserveSpot(car);                  
        if (!spotFound)
            return -1;
        if( spot[--spotNum].isMoped() )
            avalibleMopedSpots--;
        else
            avalibleSpots--;
        return spotNum;
    }
    /**
     * Allows user to check into spot. Calls that spots check in method and
     * returns if successful. Should only be available if Student has a spot 
     * reserved.
     * @param pSpotNum The spot number to be check into.
     * @return Whether check in was successful.
     */
    public boolean checkIn(int pSpotNum){
        return spot[pSpotNum].checkIn();
    }
    /**
     * Allows the user to check out of a spot. Calls that spots check out 
     * method and returns if successful.
     * @param pSpotNum The spot number to be checked out of.
     * @return Whether check out is successful.
     */
    public boolean checkOut(int pSpotNum ){
        boolean moped = spot[pSpotNum].isMoped();
        boolean temp = spot[pSpotNum].checkOut();
        if (temp)
        {
            if(moped)
                avalibleMopedSpots++;
            else
                avalibleSpots++;
            return true;
        }
        return false;
    }
    /**
     * Checks if a certain spot is available and returns the result. 
     * @param pSpotNum The spot to be checked.
     * @return True if spot is open, false if spot is reserved or checked into.
     */
    public boolean checkIfSpotAvailble( int pSpotNum ){
        return spot[pSpotNum].checkAvailable();
    }
    public void override( int pSpotNum ){
        spot[pSpotNum].checkOut();
    }
    /**
     * Prints a list of a spots and their availability.
     */
    public void print(){
        System.out.println("Spot availabilitiy of lot: " + lotNum);
        System.out.println("Spots: " + avalibleSpots + 
                '\n' + "Moped spots: " + avalibleMopedSpots);
        for(int i=0; i < spot.length; i++)
        {
            System.out.print("Spot: "+ (i+1) + " is "); 
            if(!spot[i].checkAvailable())
                System.out.print("un");
            System.out.println("available.");
        }
    }
    /**
     * Testbed
     * @param args 
     */
    public static void main(String args[]){        
        Lot testLot = new Lot(5,2);        
        testLot = new Lot(5,2);
        Vehicle testMoped = new Vehicle("AAA001", "Honda", "1989 Spree", "red",
                                        true);
        Vehicle testCar = new Vehicle();
        testLot.print();
        for(int i=0; i < 5 ; i++)
            System.out.println(testLot.reserveSpot(testCar)==i);
        System.out.println(testLot.reserveSpot(testMoped)==5);
        System.out.println(testLot.checkOut(2));
        System.out.println();
        //for(int i=0; i < 7; i++)
        //    System.out.println(testLot.checkIfSpotAvailble(i));
        System.out.println();
        System.out.println(testLot.reserveSpot(testCar)==2);
        
        System.out.println(testLot.reserveSpot(testMoped)==6);
        System.out.println(testLot.reserveSpot(testMoped)==-1);
        for(int i=0; i < 7; i++)
            System.out.println(!testLot.checkIfSpotAvailble(i));
        testLot.print();
    }
}