/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;


/**
 * Heater object
 * @author Mark Maupin
 */
public class Heater extends Component {
    
    Heater(Pin heaterPin){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(heaterPin, "Heater", PinState.LOW);
    }
}
