/**
 * This class maintains information of a single parking spot. It keeps track
 * of whether or not a spot is available and methods for a card to 
 * check in or out of a spot.
 * 
 * @author Quinn
 */
public class ParkingSpot {
    private int spotNum;
    private Vehicle carInSpot = null;
    private boolean isMopedSpot;
    private boolean isAvailable; 
    
    /**
     * This constructor takes in two parameters which are used to set the 
     * spot number and whether a spot is a moped spot. It then sets the 
     * availability to true.
     * @param num the spots designated number.
     * @param moped whether a spot is for a moped.
     */
    public ParkingSpot( int num, boolean moped){
        spotNum = num;
        isMopedSpot = moped;
        isAvailable = true;
    }
    /**
     * Returns if the spot is open.
     * @return the availability of the spot. 
     */
    public boolean checkAvailable(){
        return isAvailable;
    }
    /**
     * This methods is for when a spot is attempted to be reserved. If 
     * successful the availability is set to false and true is returned.
     * If the spot is not open or the vehicle is the wrong type it returns 
     * false.
     * @param car the car that wishes to reserve the spot.
     * @return whether the reservation was successful. 
     */
    public boolean reserveSpot(Vehicle car){
        if (isAvailable){
            if (!(car.moped() ^ isMopedSpot)){
                carInSpot = car;
                isAvailable = false;
                return true;    
            }            
        }
        return false;            
    }
    /**
     * This methods allows a user to attempt to check out of a spot. It returns
     * true if the checkout is successful and false if the user was never 
     * checked in the first place.
     * @return whether or not the checkout was successful.
     */
    public boolean checkOut(){
        if( isAvailable )
            return false;
        return isAvailable = true;       
    }    
    public static void main( String args[] )
    {
        ParkingSpot testSpot = new ParkingSpot(0,false);
        ParkingSpot testMopedSpot = new ParkingSpot(1,true);
        Vehicle testCar = new Vehicle();
        Vehicle testMoped = new Vehicle("AAA001", "Honda", "1989 Spree", "red",
                                        true);        
        System.out.println(testSpot.checkAvailable());
        System.out.println(testSpot.reserveSpot(testCar));
        System.out.println(!testSpot.checkAvailable());        
        System.out.println(!testSpot.reserveSpot(testCar));
        System.out.println(testSpot.checkOut());
        System.out.println(testSpot.reserveSpot(testCar));
        System.out.println(!testSpot.checkAvailable());    
        System.out.println(testSpot.checkOut());
        System.out.println(!testSpot.reserveSpot(testMoped));
        System.out.println(!testMopedSpot.reserveSpot(testCar));        
        System.out.println(testMopedSpot.reserveSpot(testMoped));
        
    }
}
