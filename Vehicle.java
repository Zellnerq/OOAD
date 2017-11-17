/**
 *  This entity Class maintains information about a registered vehicle in the 
 * system. It has methods to pass its data and print the information held. 
 * @author Quinn
 */
public class Vehicle {
    private String plateNum;
    private String make;
    private String model;
    private String color;
    private boolean isMoped;
    
    /**
     * Default constructor. Intended only for testing.
     */
    public Vehicle(){
        plateNum = "AAA000";
        make = "Ford";
        model = "Model T";
        color = "Black";    
        isMoped = false;
    }
    /**
     * This constructor sets all information about the vehicle. 
     * @param num used to set the plate number.
     * @param carMake used to set car make.
     * @param carModel used to set car model.
     * @param carColor used to set car color.
     * @param carIsMoped used to determine whether a vehicle is a moped.
     */
    public Vehicle( String num,String carMake,String carModel,String carColor,
                    boolean carIsMoped){
        plateNum = num;
        make = carMake;
        model = carModel;
        color = carColor;
        isMoped = carIsMoped;
    }
    /**
     * Allows classes to tell if the vehicle is a moped.
     * @return whether the vehicle is a moped.
     */
    public boolean moped(){
        return isMoped;
    }
    /**
     * Returns if the plate matches the string. Not case sensitive
     * @return plate number of the car
     */
    public boolean checkPlate(String plateToCompare){
       return plateNum.equalsIgnoreCase(plateToCompare);
    }
    /**
     * This method overrides the toString() method to instead print the 
     * make, model, color, and plate number of the vehicle.
     * @return String of all info about vehicle.
     */
    @Override
    public String toString(){
        return make + ", " + model + ", " + color + ", " + plateNum;
    }
    
    /**
     * Used to test constructors and toString() methods.
     * @param args unused
     */
    public static void main( String args[] ){
        Vehicle testCar = new Vehicle();    
        System.out.println(!testCar.isMoped);
        System.out.println(testCar.toString().matches("Ford, Model T,"
                                                        + " Black, AAA000"));
        Vehicle testMoped = new Vehicle("AAA001", "Honda", "1989 Spree", "red",
                                                                        true);
        System.out.println(testMoped.toString().matches("Honda, 1989 Spree, red"
                                                                 + ", AAA001"));
        System.out.println(testMoped.isMoped);
                
    }
            
}
