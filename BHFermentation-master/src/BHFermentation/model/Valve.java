/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import java.util.Observable;

/**
 * Valve provides methods for opening and closing valves
 * needs logic from I2C for current percentage
 * @author Mark Maupin
 */
public class Valve extends Observable{
    private final GpioPinDigitalOutput open;
    private final GpioPinDigitalOutput close;
    boolean acs = false;
    static int closedCount = 4;
    Valve(Pin open, Pin close){
        this.open = GPIO.provisionDigitalOutputPin(open, "Valve Open", PinState.LOW);
        this.close = GPIO.provisionDigitalOutputPin(close, "Valve Close", PinState.HIGH);
        
    }
    
    /**
     * sets the pin close as off
     * opens the valve
     */
    private void Open(){
        if(close.isHigh()){
            closedCount--;
            close.setState(PinState.LOW);
        }

        open.setState(PinState.HIGH);
        setChanged();
        notifyObservers();
    }
    
    /**
     * sets the pin open as off
     * closes the valve
     */
    private void Close(){
        if(open.isHigh()){
            closedCount++;
            open.setState(PinState.LOW);
        }
        
        close.setState(PinState.HIGH);
        setChanged();
        notifyObservers();
    }
    
    /**
     * Not implemented in this version. We're assuming a binary state for the
     * valves
     */
    public void Stop(){
        
    }
    
    /**
     * valveControl- controls the valve
     * @param state 0 sets ACS on, 1 sets valve on, 2 sets valve off
     * @return the count of closed valves
     */
    public int valveControl(int state){
        switch (state){
            case 0: 
                ACS(true);
                return closedCount;
            case 1:
                Open();
                ACS(false);
                
                return closedCount;
            case 2:
                Close();
                ACS(false);
                
                return closedCount;
            default:
                return closedCount;
        }
    }
    
    /**
     * setter for the ACS flag
     * @param state on/off
     */
    void ACS(boolean state){
        this.acs = state;
    }
    
    /**
     * getter for the state of valve
     * @return true if close is energized
     */
    public boolean getState(){
        return close.isHigh();
    }
    
    /**
     * getter for closed count
     * @return number of closed valves in the system
     */
    public int getCount(){
        return closedCount;
    }
    
    /**
     * getter for acs
     * @return true if ACS is active for a valve
     */
    public boolean getACS(){
        return acs;
    }
}
