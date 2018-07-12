/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentationTests;


import BHFermentation.model.ProcessController;
import junit.framework.TestCase;





/**
 *  As of yet unsure which classes need to be targeted for testing
 * @author Lane M
 * @author Mark Maupin 
 */
public class TestDriver extends TestCase
{
    private static final ProcessController testPC = new ProcessController();
    
    /**
     * tests heater1, sets heater state, checks against it
     */
    public void testHeater1()
    {
        
        testPC.setHeater1(true);
        assertEquals("Result: false. Heater 1 should be set to true.", "On", testPC.getHeater1State());
      
    }
    
    /**
     * tests heater2, sets heater state, checks against it
     */
    public void testHeater2()
    {
        testPC.setHeater2(true);
        assertEquals("Result: false. Heater 2 should be set to true.", "On", testPC.getHeater2State());
    }
        
    /**
     * tests fan1,  sets fan state, checks against it
     */
    public void testfan1()
    {
        testPC.setFan1(true);
        assertEquals("Result: false. Fan 1 should be set to true.", "On", testPC.getFan1State());
    } 

    /**
     * tests fan2,  sets fan state, checks against it
     */
    public void testfan2()
    {
        testPC.setFan2(true);
        assertEquals("Result: false. Fan 2 should be set to true.", "On", testPC.getFan2State());
    } 

    /**
     * tests valve1 CC value. passes if getCC returns expected result
     */
    public void test1ValveCC()
    {
        testPC.setValve1(2);
        testPC.setValve2(2);
        testPC.setValve3(2);
        testPC.setBypass(2);
        assertEquals("cc does not equal 4", 4, testPC.getCC());
    }
    
   /**
    * tests valve1 CC value, passes if getCC returns expected result
    */
    public void test1Valve1()
    {
        testPC.setValve1(2);
        testPC.setValve2(2);
        testPC.setValve3(2);
        testPC.setBypass(2);
        testPC.setValve1(1);
        assertEquals("cc does not equal 3", 3, testPC.getCC());
    }
    
    /**
     * tests valve2 CC value, passes if getCC returns expected result
     */
    public void test1Valve2()
    {
        testPC.setValve1(2);
        testPC.setValve2(2);
        testPC.setValve3(2);
        testPC.setBypass(2);
        testPC.setValve1(1);
        testPC.setValve2(1);
        assertEquals("cc does not equal 2", 2, testPC.getCC());
    }
    
    /**
     * tests valve 3 CC value, passes if getCC returns expected result
     */
    public void test1Valve3()
    {
        testPC.setValve1(2);
        testPC.setValve2(2);
        testPC.setValve3(2);
        testPC.setBypass(2);
        testPC.setValve1(1);
        testPC.setValve2(1);
        testPC.setValve3(1);
        assertEquals("cc does not equal 1", 1, testPC.getCC());
    }
    
    /*
    This method tests that the bypass component is functioning properly
    sets the state to 1 and checks the result
    @author Lane M
    */
    
    /**
     * tests bypass, sets bypass open to true, checks against close, should be false
     */
    public void testBypass()
    {
        testPC.setBypass(1);
        assertEquals("Bypass has incorrect state", false, testPC.getBypassState());
    }

    /**
     * tests vessel1 in chamber 1, sets default values, checks against those values
     */
    public void testVessel1C1()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel1Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v1 Recipe does not match", "Stout", testPC.c1v1Recipe());
        assertEquals("c1v1 Activity does not match", true, testPC.c1v1Activity());
        assertEquals("c1v1 Set Point does not match", 50.0, testPC.c1v1SetPoint());
    }
    
    /**
     * tests vessel 2 in chamber 1, sets default values, checks against those values
     */
    public void testVessel2C1()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel2Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v2 Recipe does not match", "Stout", testPC.c1v2Recipe());
        assertEquals("c1v2 Activity does not match", true, testPC.c1v2Activity());
        assertEquals("c1v2 Set Point does not match", 50.0, testPC.c1v2SetPoint());
    }
    
    /**
     * tests vessel 3 in chamber 1, sets default values, checks against those values
     */
    public void testVessel3C1()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel3Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v3 Recipe does not match", "Stout", testPC.c1v3Recipe());
        assertEquals("c1v3 Activity does not match", true, testPC.c1v3Activity());
        assertEquals("c1v3 Set Point does not match", 50.0, testPC.c1v3SetPoint());
    }
    
    /**
     * tests vessel 4 in chamber 1, sets default values, checks against those values
     */
    public void testVessel4C1()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel4Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v4 Recipe does not match", "Stout", testPC.c1v4Recipe());
        assertEquals("c1v4 Activity does not match", true, testPC.c1v4Activity());
        assertEquals("c1v4 Set Point does not match", 50.0, testPC.c1v4SetPoint());
    }
    
    /**
     * tests vessel 1 in chamber 2, sets default values, checks against those values
     */
    public void testVessel1C2()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel1Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v1 Recipe does not match", "Stout", testPC.c2v1Recipe());
        assertEquals("c2v1 Activity does not match", true, testPC.c2v1Activity());
        assertEquals("c2v1 Set Point does not match", 50.0, testPC.c2v1SetPoint());
    }
    
    /**
     * tests vessel 2 in chamber 2, sets default values, checks against those values
     */
    public void testVessel2C2()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel2Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v2 Recipe does not match", "Stout", testPC.c2v2Recipe());
        assertEquals("c2v2 Activity does not match", true, testPC.c2v2Activity());
        assertEquals("c2v2 Set Point does not match", 50.0, testPC.c2v2SetPoint());
    }

    /**
     * tests vessel 3 in chamber 2, sets default values, checks against those values
     */
    public void testVessel3C2()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel3Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v3 Recipe does not match", "Stout", testPC.c2v3Recipe());
        assertEquals("c2v3 Activity does not match", true, testPC.c2v3Activity());
        assertEquals("c2v3 Set Point does not match", 50.0, testPC.c2v3SetPoint());
    }  
    
   /**
    * tests vessel 4 in chamber 2, sets default values, checks against those values
    */
    public void testVessel4C2()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel4Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v4 Recipe does not match", "Stout", testPC.c2v4Recipe());
        assertEquals("c2v4 Activity does not match", true, testPC.c2v4Activity());
        assertEquals("c2v4 Set Point does not match", 50.0, testPC.c2v4SetPoint());
    } 
    
    /**
     * tests ChestFreezer, sets state, checks again the state
     */
    public void testChestFreezer()
    {
        boolean state = true;
        
        testPC.setChestFreezer(state);
        assertEquals("Chest Freezer has incorrect state.", true, testPC.getChestFreezerState());
    }
    
    /**
     * tests Chiller, sets state, checks against the state
     */
    public void testChiller()
    {
        boolean state = true;
        
        testPC.setChiller(state);
        assertEquals("Chiller has incorrect state.", true, testPC.getChillerState());
    }
    
}
    
   
 
