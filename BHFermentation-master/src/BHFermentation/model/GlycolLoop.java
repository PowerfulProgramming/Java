/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

//GPIO imports: 04 is gpclk0 for the 1 wire transfer
//Using pi4j pinout, differs from Broadcom's. more info at
//http://pi4j.com/images/j8header-b-plus-large.png
import com.pi4j.component.temperature.TemperatureSensor;
import static com.pi4j.io.gpio.RaspiPin.GPIO_00; //fan 1
import static com.pi4j.io.gpio.RaspiPin.GPIO_01; //heater 1
import static com.pi4j.io.gpio.RaspiPin.GPIO_02; //fan 2
import static com.pi4j.io.gpio.RaspiPin.GPIO_03; //heater 2
import static com.pi4j.io.gpio.RaspiPin.GPIO_29; //pump
import static com.pi4j.io.gpio.RaspiPin.GPIO_05; //chiller
import static com.pi4j.io.gpio.RaspiPin.GPIO_06; //chest freezer
import static com.pi4j.io.gpio.RaspiPin.GPIO_21; //bypass valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_22; //bypass valve close
import static com.pi4j.io.gpio.RaspiPin.GPIO_23; //chamber 1 valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_24; //chamber 1 valve close
import static com.pi4j.io.gpio.RaspiPin.GPIO_25; //chamber 2 valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_26; //chamber 2 valve close
import static com.pi4j.io.gpio.RaspiPin.GPIO_27; //ice tank valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_28; //ice tank valve close
import com.pi4j.io.w1.W1Master;
import java.util.List;


/**
 * GlycolLoop contains all objects that are connected to the cooling system
 * @author Mark Maupin
 */
public class GlycolLoop {
    
    final Valve bypass, c1Valve, c2Valve, iCValve;
    ValveObserver c1O, c2O, icO, bypassO;
    final ChestFreezer chestFreezer;
    final Pump pump;
    final Chiller chiller;
    ComponentObserver chestFreezerO, pumpO, chillerO;
    final TemperatureSensor sensor1, sensor2;
    W1Master w1Master;
    final Chamber chamber1, chamber2;
    //final IceTank iceTank;
    List sensors;
    
    /**
     * Constructs the Glycol Loop subsystem
     * GPIO pins are ordered in loose organization
     */
    GlycolLoop(){
        this.w1Master = new W1Master();
        this.sensors = w1Master.getDevices();
        sensor1 = (TemperatureSensor) sensors.get(0);
        sensor2 = (TemperatureSensor) sensors.get(1);
        this.chamber1 = new Chamber(GPIO_00, GPIO_01, 0);
        this.chamber2 = new Chamber(GPIO_02, GPIO_03, 1);
        
        this.pump = new Pump(GPIO_29);
        this.chiller = new Chiller(GPIO_05);
        this.chestFreezer = new ChestFreezer(GPIO_06);
        //this.iceTank = new IceTank(GPIO_07);
        chestFreezerO = new ComponentObserver(chestFreezer, 3, 1, 2);
        pumpO = new ComponentObserver(pump, 0, 1, 2);
        chillerO = new ComponentObserver(chiller, 1, 1, 2);
        
        this.bypass = new Valve(GPIO_21, GPIO_22);
        this.c1Valve = new Valve(GPIO_23, GPIO_24);
        this.c2Valve = new Valve(GPIO_25, GPIO_26);
        this.iCValve = new Valve(GPIO_27, GPIO_28);
        this.c1O = new ValveObserver(c1Valve, 0);
        this.c2O = new ValveObserver(c2Valve, 1);
        this.icO = new ValveObserver(iCValve, 2);
        this.bypassO = new ValveObserver(bypass, 3);
        
    }
    
    /**
     * getter for our test temperature sensor
     * @return a temperature value as a double
     */
    public double getTemp1(){
        return sensor1.getTemperature();
        
    }
    
    /**
     * getter for our 2nd test temperature sensor
     * @return a temperature value as a double
     */
    public double getTemp2(){
        return sensor2.getTemperature();
    }
    
}
