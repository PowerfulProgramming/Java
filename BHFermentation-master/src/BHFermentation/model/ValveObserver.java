/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import BHFermentation.view.JFrameView;
import java.util.Observable;
import java.util.Observer;

/**
 * observer class for valves
 * @author Mark Maupin
 */
public class ValveObserver implements Observer{

    boolean close;
    int row;
    
    /**
     * constructor for the observer
     * @param valve concrete valve to be observed
     * @param row the row in a table it will presented on
     */
    public ValveObserver(Valve valve, int row){
        valve.addObserver(this);
        close = valve.getState();
        this.row = row;
    }
    
    /**
     * sends updated data to process controller
     * @param o the object being observed
     * @param arg generated arguments
     */
    @Override
    public void update(Observable o, Object arg) {
        Valve valve = (Valve)o;
        if(close ^ valve.getState()){
            close = valve.getState();
            if(close){
                JFrameView.processController.updateData("on", row, 2, 3);
                JFrameView.processController.updateData("off", row, 1, 3);
            }else{
                JFrameView.processController.updateData("off", row, 2, 3);
                JFrameView.processController.updateData("on", row, 1, 3);
            }
                
        }
    }
    
}
