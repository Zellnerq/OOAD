/**
 *
 * @author Zellnerq
 */
//import package.class ManageParking();
public class Main {

    private static final int DEMO_SIZE = 5;
    public static Lot lots[] = new Lot[DEMO_SIZE];
    public static User users[] = new User[DEMO_SIZE];
    //public static 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for ( int i = 0; i < DEMO_SIZE; i++ ){
            lots[i] = new Lot();
            users[i] = new StudentStaff();
        }
        users[DEMO_SIZE-1] = new Admin();
        for ( User u : users){
            u.print();
        }
        
        LogInPage m = new LogInPage();
        m.setVisible(true);
        // TODO code application logic here
    }
    
    public static StudentStaff findUser(Vehicle ve)
    {
       boolean hasCar = false;
       StudentStaff s = new StudentStaff();
       for(int i = 0; i < users.length; i++)
       {
          if(users[i] instanceof StudentStaff && !hasCar)
          {  
             s = (StudentStaff)users[i];
             hasCar = s.findCar(ve);
          }
       }
       return s;
    }        
}
