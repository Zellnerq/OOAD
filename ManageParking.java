/**
 *
 * @author Quinn
 */
public class ManageParking{

    
    public ManageParking(){
    }
    public static String updateAvailability(int index) {
        if( Main.lots[index].checkAvailability() ){
            return Main.lots[index].toString();
        }
        else
            return "Lot: " + index + " is full!";
    }
    public static int reserveSpot(Vehicle v, int i){
        return Main.lots[i].reserveSpot(v);
    }
    public static boolean checkIn(Reservation r){
        if ( r == null)
            return false;
        else {
            return Main.lots[r.getLot()].checkIn(r.getSpot());
        }
    }
    public static boolean checkOut(Reservation r){
        return (Main.lots[r.getLot()].checkOut(r.getSpot()));        
    }
    public static void override( int lotNum, int spotNum){
        for(int i = 0; i < Reservation.index; i++){
            if ( Main.resList[i].getLot() == lotNum )
                if ( Main.resList[i].getSpot() == spotNum ){
                    StudentStaff temp = Main.resList[i].getStudentStaff();
                    Main.resList[i].setActive(false);
                    temp.setReservation(null);
                    Main.users[0] = temp;
                    Main.lots[lotNum].override(spotNum);
                }
                    
        }
    }
}
