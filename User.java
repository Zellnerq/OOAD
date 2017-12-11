/**
 * This class intended as a super class for all users. It maintains basic
 * demographic information of a user.
 * @author Quinn
 */
public class User {
    private static int index = 0;
    private int ID;
    private String name;
    private String password;
    private String userName;
    
    /**
     * Default constructor. Used for testing only.
     */
    public User(){
        ID = index++;
        name = "Jane Doe";
        password = "password";
        userName ="DoeJ";
    }
    /**
     * This constructor takes in a ID number, the Users name, Their password,
     * and the Username for their account.
     * @param num IDnumber
     * @param newName Name of User
     * @param pass User's password
     * @param newUser UserName
     */
    public User(int num, String newName, String pass, String newUser){
        ID = num;
        name = newName;
        userName = newUser;
        password = pass;
    }
    /**
     * Returns the Users name.
     * @return Users name
     */
    public String getName(){
        return name;
    }
    /**
     * Gets the User's ID number
     * @return ID number
     */
    public int getID(){
        return ID;
    }
    /**
     * Prints the users ID, name, password, and userName.
     */
    public void print(){
        System.out.println( "" + ID + '\n' + name + '\n' + password + '\n'
                                                                    + userName);
    }
    /**
     * Test Bed
     * @param args Unused.
     */
    public static void main( String args[] ){
        User nobody = new User();
        nobody.print();
    }
}
