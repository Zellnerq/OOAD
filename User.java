/**
 * This class intended as a super class for all users. It maintains basic
 * demographic information of a user.
 * @author Quinn
 */
public class User {
    private int ID;
    private String name;
    private String password;
    private String userName;
    
    public User(){
        ID = 0;
        name = "Jane Doe";
        password = "password";
        userName ="DoeJ";
    }
    public User(int num, String newName, String pass, String newUser){
        ID = num;
        name = newName;
        userName = newUser;
        password = pass;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
}
