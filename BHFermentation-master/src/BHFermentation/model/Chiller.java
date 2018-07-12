/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;
import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.Pin;

/**
 * represents the Chiller, extends component
 * @author Mark Maupin
 */
public class Chiller extends Component {
    //private final Sensor sensor;
    
    Chiller(Pin pin){
       componentPin = GPIO.provisionDigitalOutputPin(pin, "Chiller", PinState.LOW);
       //sensor = new Sensor();
    }
}
