/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import com.pi4j.io.gpio.Pin;
/**
 * Chamber object holds everything that is directly associated with a chamber
 * @author Mark Maupin
 */
public class Chamber{
    
    public int temperature;
    //private final Sensor sensor;
    Vessel vessel1, vessel2, vessel3, vessel4;
    VesselObserver v1, v2, v3, v4;
    final Fan fan;
    final Heater heater;
    ComponentObserver fanO, heaterO;
    int ID;
    
    /**
     * Should not instantiate a chamber without a fan and a heater
     * @param fanPin
     * @param heaterPin 
     */
    Chamber(Pin fanPin, Pin heaterPin, int ID){
        this.ID = ID;
        fan = new Fan(fanPin);
        heater = new Heater(heaterPin);
        temperature = 0;
        vessel1 = new Vessel(0 + 4 * ID);
        vessel2 = new Vessel(1 + 4 * ID);
        vessel3 = new Vessel(2 + 4 * ID);
        vessel4 = new Vessel(3 + 4 * ID);
        v1 = new VesselObserver(vessel1, ID);
        v2 = new VesselObserver(vessel2, ID);
        v3 = new VesselObserver(vessel3, ID);
        v4 = new VesselObserver(vessel4, ID);
        heaterO = new ComponentObserver(heater, 4, 1, ID);
        fanO = new ComponentObserver(fan, 5, 1, ID);
        
    }
    
    /**
     * gets vessels associated with the chamber
     * @return the vessel
     */
    public Vessel getVessels(){
        return vessel1;
    }
    
    /**
     * setter for the heater
     * @param state on/off
     */    
    public void setHeater(boolean state){
        heater.setState(state);
    }
    
    /**
     * get the temperature
     * @return temperature in Celsius
     */
    public int getTemperature(){
        return temperature;
    }
    
    /**
     * fan setter
     * @param state on/off
     */
    public void setFan(boolean state){
        fan.setState(state);
    }
}
