/**
 *
 * @author Quinn
 */
public class StudentStaff extends User{
    private double balance = 0.00;
    private Vehicle cars[] = new Vehicle[0];    
    /**
     * This method adds a Vehicle to a growable array for the Student.
     * If the plate number already exists it returns false, else it will return
     * true.
     * @param newCar The car to be added.
     * @return True if car is add to the Vehicle list, returns false otherwise.
     */
    public boolean addCar(Vehicle newCar){
        for (Vehicle car : cars) {
            if (car.checkPlate(newCar.getPlate())) {
                return false;
            }
        }
        Vehicle temp[] = new Vehicle[cars.length + 1];
        System.arraycopy(cars, 0, temp, 0, cars.length);
        temp[cars.length] = newCar;
        cars = temp;
        return true;
    }
    /**
     * Removes a car from a the growable array if it is there and shirnks the 
     * array. This method is currently broken and is a work in progress.
     * @param carToRemove The car to be removed
     * @return True if removed, false if not found.
     */
    public boolean deleteCar( Vehicle carToRemove){
        boolean found = false;
        int index = 0;
        while(!found && index < cars.length){
            found = cars[index++].equals(carToRemove);
        }
        if (found){
            Vehicle temp[] = new Vehicle[cars.length -1];
            System.arraycopy( cars , 0 , temp , 0, index - 1);
            if( index < cars.length)
                System.arraycopy(cars, index, temp, index + 1, cars.length -index);
            cars = new Vehicle[index - 1];
            System.arraycopy(temp, 0, cars, 0, temp.length);
        }        
        return found;     
    }
    public void updateBalance( int newBalance ){
        balance = newBalance;
    }
    public double getBalance (){
        return balance;
    }            
    /**
     * Prints the User's ID, name, password, username, and cars.
     */
    @Override
    public void print(){
        super.print();
        for(Vehicle car : cars){
            System.out.println(car.toString());
        }
    }
    public static void main( String args[] ){
        StudentStaff staff = new StudentStaff();
        staff.print();
        Vehicle temp = new Vehicle();
        //System.out.println(staff.addCar(temp));
        temp = new Vehicle("AAA001", "Honda", "1989 Spree", "Red", true);
        System.out.println(staff.addCar(temp));
        staff.print();
        System.out.println(staff.deleteCar(temp));
        staff.print();
        
    }
}

