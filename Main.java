/**
 *
 * @author Zellnerq
 */
//import package.class ManageParking();
public class Main {

    public static Lot lots[] = new Lot[5];
    public static User users[] = new User[5];
    //public static 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for ( Lot lot : lots ){
            lot = new Lot();
        }
        for ( User u : users){
            u = new StudentStaff();
        }
        LogInPage m = new LogInPage();
        m.setVisible(true);
        // TODO code application logic here
    }
    
}
