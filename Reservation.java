/**
 *
 * @author maclayw
 */
import java.util.Date;
public class Reservation {
    private int spot, lot, date, id;
    private String plate;
    private StudentStaff resHolder;
    private boolean isActive = false;
    public static int index = 0;
    
    public Reservation( int s, int l, User u){
        id = index++;
        spot = s;
        lot = l;
        if ( u instanceof StudentStaff){
            resHolder = (StudentStaff)u;
            plate = ((StudentStaff) u).getVehicle().getPlate();
        }
        Date resDate = new Date();
        date = resDate.getDate();
    }
    
    public int getID(){
        return id;
    }
    
    public boolean getActive(){
        return isActive;
    }
    
    public boolean setActive( boolean b){
        return isActive = b;
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
