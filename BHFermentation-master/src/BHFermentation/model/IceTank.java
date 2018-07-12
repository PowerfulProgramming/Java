/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.Pin;

/**
 * The ice maker for the system currently non functional due to lack of GPIO's
 * @author Mark Maupin
 */
public class IceTank extends Component{
    //private final Sensor sensor;
    IceTank(Pin pin){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(pin, "Ice Tank", PinState.LOW);
       //sensor = new Sensor();
    }
}
