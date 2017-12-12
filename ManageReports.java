/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

/**
 *
 * @author neefez
 */
public class ManageReports 
{
    public static final int MAX_REPORTS = 1000;
    public static int numReports = 0;
    public static Report[] reportList = new Report[MAX_REPORTS];
    
    public static void addReport(Vehicle v, int lot, int space)
    {
       Lot accessLot = Main.lots[lot];
       Date d = new Date();
       int t = d.getDate();
       Report newrep = new Report(v, accessLot.getSpot(space), Main.lots[lot], t);
       reportList[numReports++] = newrep;
    } 
    
    public static void viewReports()
    {
       ReportList newList = new ReportList();
       newList.setVisible(true);
    }
    
    public static void approveReport(int reportNum, double amount)
    {
       Vehicle v = reportList[reportNum].getVehicle();
       StudentStaff s = Main.findUser(v);
       if(s.getID() != 0)
       {
          s.updateBalance(-amount);
       }
    }
    
    public static void deleteReport(int reportNum)
    {
       if(numReports != 1)
          reportList[reportNum] = reportList[--numReports];
       else
       {
          reportList[reportNum] = null;
          numReports--;
       }
    }
}
