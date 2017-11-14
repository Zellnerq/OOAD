/**
 * This class maintains data about a lot. It contains an array of spots used 
 * to represents the parking spots in the lot. 
 * @author Quinn
 */
public class Lot {
    private ParkingSpot spot[];
    private int avalibleSpots, lotNum, numMopedSpots, avalibleMopedSpots;
    
    /**
     * Default constructor. For testing only. 
     */
    public Lot(){
        avalibleSpots = 100;
        spot = new ParkingSpot[100];
        lotNum = 0;
        for(int i=0; i<100; i++)
        {
            spot[i] = new ParkingSpot(i, false);
        }
    }
    /**
     * This constructor takes in a number of normal car spots, the number
     * of moped spots and the designated lot number. It then initializes the
     * parking spots based on their type.
     * @param spots
     * @param num
     * @param numMoped 
     */
    public Lot( int spots, int num, int numMoped){
        avalibleSpots = spots;
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
     * @param car
     * @return 
     */
    public int reserveSpot(Vehicle car){
        boolean spotFound = false;
        int spotNum = 0;
        while(!spotFound && spotNum < (spot.length)){
            spotFound = spot[spotNum++].reserveSpot(car);            
        }        
        if ((spotNum) > spot.length){
            return -1;
        }
        return spotNum;
    }
    /**
     * Testbed, work in progress.
     * @param args 
     */
    public static void main(String args[]){        
        Lot testLot = new Lot();
        
        
        
    }
}