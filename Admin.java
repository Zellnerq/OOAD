
public class Admin extends User{
    
    final int MAX_REPORTS = 100;
    
    private Report reports [] = new Report[MAX_REPORTS];
    private int numReports = 0;
    private Vehicle cars [];
    /*
     * 
     * @param i 
     */
    public void viewReport(int i)
    {
        System.out.println(reports[i].toString());
    }
    public void addReport()
    {
         Vehicle tempV = new Vehicle();
         ParkingSpot tempS = new ParkingSpot( 1, false);
         Lot tempL = new Lot();
         int time = 800;
        // Report(Vehicle v, ParkingSpot s, Lot l, int t)
          reports[numReports++] = new Report(tempV,tempS, tempL,time);
    }
    
    public void removeReport(int r)
    {
            
    }
 
    public int getNum()
    {
        return numReports;
    }
    
    public static void main(String args[])
    {
        Admin a = new Admin();
        a.addReport();
        a.addReport();
        a.addReport();
        for(int i = 0; i < a.getNum(); i++)
            a.viewReport(i);
    }
    
}
