package androidscavenger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
* Android Scavenger is an application where you can search through inventory which contains randomly generated 400 
* new line of droids which were created by taking parts from old droid. This application is using very complex algorithm.
*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
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


