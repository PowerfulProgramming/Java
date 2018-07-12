/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;


import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.Pin;

/**
 * The pump object
 * @author Mark Maupin
 */
public class Pump extends Component{
    Pump(Pin pin){
       componentPin = GPIO.provisionDigitalOutputPin(pin, "Pump", PinState.LOW);
    }
}
