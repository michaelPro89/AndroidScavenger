/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidscavenger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author MichaelTheProgrammer
 */
public class SerialGenerator {
    
    // ex. 1098904  - 7 digits minimum and maximum
    private int serialNumber;
    private int max = 10000000;
    private int min =  1000000;
    private ArrayList <Integer> serials = new ArrayList(900);
    
    
  
    private Random rg = new Random();
    

    //Methods
    public void generateSerialNumbers() {

        int listSize = 900;

        while (0 < listSize) {
            //generate random 7 digits serial
            this.serialNumber = rg.nextInt(this.max - this.min) + this.min;

            //if the generated serial is not inside the serial list add it to the list 
            if (!this.serials.contains(this.serialNumber)) {

                this.serials.add(this.serialNumber);
                listSize--;

            }
        }

    }

    
    
    
    public int getSerial(int index){
        
        int serial = this.serials.get(index);
   
        this.serials.remove(index);

        return serial;
        
    }
    
    
    
}


