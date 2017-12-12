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
    private boolean isAvailable = false; 
    private boolean checkedIn; 
    
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
     * This getter method returns if the spot is a moped spot.
     * @return True is a moped spot else false.
     */
    public boolean isMoped(){
        return isMopedSpot;
    }
    /**
     * This getter method returns the Vehicle in spot if there is one. 
     * @return Vehicle in spot or null if spot is empty.
     */
    public Vehicle car(){
        return carInSpot;
    }
    /**
     * This methods is for when a spot is attempted to be reserved. If 
     * successful the availability is set to false and true is returned.
     * If the spot is not open or the vehicle is the wrong type it returns 
     * false. Sets carInSpot to the Vehicle passed in.
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
     * This method checks a car into a spot if it's reserved. If the spot is 
     * not reserved or if the spot is occupied returns false.
     * @return True if checkIn success, false if checkIn fails.
     */
    public boolean checkIn(){
        if( !isAvailable && !checkedIn )
        {
            return checkedIn = true;
        }
        return false;       
    }
    /**
     * This methods allows a user to attempt to check out of a spot. It returns
     * true if the checkout is successful and false if the user was never 
     * checked in the first place. If successful sets car in spot to null;
     * @return whether or not the checkout was successful.
     */
    public boolean checkOut(){
        if( isAvailable ){            
            return false;
        }
        carInSpot = null;    
        return isAvailable = true;       
    }    
    
    public int getSpotNumber()
    {
       return spotNum;
    }
    
    public static void main( String args[] ){
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
