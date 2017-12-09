/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neefez
 */
public class ManageReports 
{
    public static final int MAX_REPORTS = 1000;
    public static int numReports = 0;
    public static Report[] reportList = new Report[MAX_REPORTS];
    public static void addReport(Vehicle v)
    {
       Report newrep = new Report(v);
       reportList[numReports++] = newrep;
    } 
}
