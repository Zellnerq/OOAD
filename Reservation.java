/**
 *
 * @author maclayw
 */
import java.util.Date;
public class Reservation {
    int spot, lot, date;
    String plate;
    StudentStaff resHolder;
    
    public Reservation( int s, int l, User u){
        spot = s;
        lot = l;
        if ( u instanceof StudentStaff){
            resHolder = (StudentStaff)u;
            plate = ((StudentStaff) u).getVehicle().toString();
        }
        Date resDate = new Date();
        date = resDate.getDate();
    }
    
    public int getSpot()
    {
       return spot; 
    }
    
    public int getLot(){
       return lot; 
    }
    
    public int getDate(){
        return date;
    }
    
    public String getPlate(){
        return plate;
    }
    
    public StudentStaff getStudentStaff(){
        return resHolder;
    }
}
