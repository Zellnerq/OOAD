/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mulrooneyju
 */
public class Report {
    //vehicle
    //spot
    //lot
    //time
    
    private Vehicle curVehicle;
    private ParkingSpot spot;
    private Lot lot;
    private int time;
    
    Report()
    {
        curVehicle = null;
        spot = null;
        lot = null;
        time = 0;
    }
    
    Report(Vehicle v, ParkingSpot s, Lot l, int t)
    {
        curVehicle = v;
        spot = s;
        lot = l;
        time = t;
    }
    
    public String toString()
    {
       return("Vehicle: " + curVehicle.toString() + " Time: " + time);
    }
   
    public Lot getLot()
    {
       return lot;
    }       
    
    public ParkingSpot getSpace()
    {
       return spot;
    }      
    
    public String getLicense()
    {
       return curVehicle.getPlate();
    }      
    
    public int getTime()
    {
       return time;
    }      
    
    public Vehicle getVehicle()
    {
       return curVehicle;
    }
}
