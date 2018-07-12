/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import java.util.Observable;

/**
 * represents vessels
 * @author Mark Maupin
 */
public class Vessel extends Observable{
    
    private boolean state = false; //active or ready
    private String recipe;
    double setPoint;
    int ID;
    int chamberID;
    
    /**
     * constructor for the vessel
     * @param ID which vessel the concrete representation is
     */
    public Vessel(int ID){
        this.recipe = "-";
        this.setPoint = 68;
        this.ID = ID;
    }
    
    /**
     * getter for the state of the valve
     * @return true if active
     */
    public boolean getstate(){
        return this.state;
    }
    
    /**
     * getter for the setpoint
     * @return setpoint as a double
     */
    public double getSetpoint(){
        return setPoint;
    }
    
    /**
     * getter for the id value
     * @return ID as an int
     */
    public int getID(){
        return ID;
    }
    
    /**
     * setter for the state
     * @param state active/inactive
     * @param recipe name of the recipe
     */
    public void setState(boolean state, String recipe){
        this.state = state;
        this.recipe = recipe;
        setChanged();
        notifyObservers();
    }
    
    /**
     * updates the setpoint
     * @param setPoint in Celsius
     */
    public void updateSetPoint(int setPoint){
        this.setPoint = setPoint;
        setChanged();
        notifyObservers();
    }
    
    /**
     * getter for the recipe
     * @return recipe as a string
     */
    public String getRecipe(){
        return recipe;
    }
    
    /**
     * getter for the set point
     * @return setpoint as a double
     */
    public double getSetPoint()
    {
        return setPoint;
    }
}
