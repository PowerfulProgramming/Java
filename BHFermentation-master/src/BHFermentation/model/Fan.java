/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;


import com.pi4j.io.gpio.Pin;

import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;

/**
 * Fan object
 * @author Mark Maupin
 */
public class Fan extends Component{
    Fan(Pin fanPin){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(fanPin, "Fan", PinState.LOW);
    }
}
