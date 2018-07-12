/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import BHFermentation.view.JFrameView;
import java.util.Observable;
import java.util.Observer;

/**
 * observer class for observing component objects
 * @author Mark Maupin
 */
public class ComponentObserver implements Observer {

    boolean state;
    int tableID;
    int row;
    int col;
    
    /**
     * Constructor for the component observer
     * @param component concrete object being observed
     * @param row represents which row it is displayed in a table
     * @param col represents which column it is displayed in a table
     * @param tableID represents which table it is associated with
     */
    public ComponentObserver(Component component, int row, int col, int tableID){
        component.addObserver(this);
        this.state = component.getState();
        this.tableID = tableID;
        this.row = row;
        this.col = col;
    }
    
    /**
     * The update method for this observer
     * @param o the object being observed
     * @param arg generated arguments
     */
    @Override
    public void update(Observable o, Object arg) {
        Component component = (Component)o;
        
        if(state ^ component.getState()){
            state = component.getState();
            if(state){
                JFrameView.processController.updateData("on", row, col, tableID);
            }else{
                JFrameView.processController.updateData("off", row, col, tableID);
            }
            
        }
    }
    
}
