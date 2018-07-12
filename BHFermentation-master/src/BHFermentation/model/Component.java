/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;


import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import java.util.Observable;



/**
 * Contains methods common to objects with binary states on an output pin
 * @author Mark Maupin
 */
public abstract class Component extends Observable{
    
    GpioPinDigitalOutput componentPin;
    
    Component(){
        
    }
    
    /**
     * sets state of a GPIO output Pin
     * receives boolean, if true energize
     * else de energize
     * @param state on/off
     */
    public void setState(boolean state){
        if(state){
            componentPin.setState(PinState.HIGH);
        }else{
            componentPin.setState(PinState.LOW);
        }
        setChanged();
        notifyObservers();
    }
    
    /**
     * getter for component objects
     * @return boolean state
     */
    public boolean getState(){
        return componentPin.isHigh();
    }
}
