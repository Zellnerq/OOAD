/**
 * This class intended as a super class for all users. It maintains basic
 * demographic information of a user.
 * @author Quinn
 */
public class User {
    private int ID;
    private String name;
    //private Vehicle CarsOwned[];
    
    public User(){
        ID = 0;
        name = "Jane Doe";
    }
    public User(int num, String userName){
      ID = num;
      name = userName;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
}
