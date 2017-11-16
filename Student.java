/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quinn
 */
public class Student extends User{
    Vehicle cars[];
    
    /**
     * This method adds a Vehicle to array for the Student. If the plate number
     * already exists it returns false, else it will return true.
     * @param num The Vehicles plate number
     * @param make The Vehicles make.
     * @param model The Vehicles model.
     * @param color The Vehicles color.
     * @param isMoped If the vehicle is a moped.
     * @return True if car is add to the Vehicle list, returns false otherwise.
     */
    public boolean addCar(String num, String make, String model, 
                                                String color, boolean isMoped){
        for (Vehicle car : cars) {
            if (car.checkPlate(num)) {
                return false;
            }
        }
        Vehicle temp[] = new Vehicle[cars.length + 1];
        System.arraycopy(cars, 0, temp, 0, cars.length);
        temp[cars.length] = new Vehicle( num, make, model, color, isMoped );
        return true;
    }    
    public boolean deleteCar( String plateToDelete){
        boolean found = false;
        int index = 0;
        while(!found && index < cars.length){
            found = cars[index++].checkPlate(plateToDelete);
        }
        if (found){
            Vehicle temp[] = new Vehicle[cars.length -1];
            System.arraycopy(temp, 0, cars, 0, index);
            System.arraycopy(temp, index, cars, index + 1, cars.length -index);
            System.arraycopy(cars, 0, temp, 0, temp.length);
        }        
        return found;     
    }
}

