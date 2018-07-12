/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.Pin;

/**
 * Chest Freezer object, extends component
 * @author Mark Maupin
 */
public class ChestFreezer extends Component{
    //private final Sensor sensor1, sensor2;
    
    ChestFreezer(Pin pin){
    componentPin = GPIO.provisionDigitalOutputPin(pin, "Chest Freezer", PinState.HIGH);
    //sensor1 = new Sensor();
    //sensor2 = new Sensor();
    }
}
