/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidscavenger;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author M4K3L
 */
public class NewDroids extends Droids {

    
     // This is our hashmap for NEW droids
    HashMap <Integer , NewDroids> newDroidsList = new HashMap();
    
    //Store here particular model seperately
    ArrayList<NewDroids> andyList = new ArrayList();
    ArrayList<NewDroids> bettyList = new ArrayList();
    ArrayList<NewDroids> fredList = new ArrayList();
    ArrayList<NewDroids> bobiList = new ArrayList();

    
    
    
    //Available models for new droids
    private final String models[ ] = {"Andy The Android", "Betty The Busibot", "Bobi The Racedroid", "Fred The Friendlybot"};
    
     private SecureRandom randomGenerator = new SecureRandom(); 
    
    
        //Methods
        public String getRandomModel() {
         
        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.models.length);

        return this.models[randomNumber];
    }
    
    
    
     //implemented methods here
    @Override
    public void setModel (String modelName) {
        super.model = modelName;
    }

    @Override
    public void setSerialNumber(int serial) {
       super.serialNumber = serial;
    }

    @Override
    public void setBrain(String brain) {
        super.brain = brain;
    }

    @Override
    public void setMobility(String mobility) {
      super.mobility = mobility;
    }

    @Override
    public void setVision(String vision) {
        super.vision = vision;
    }

    @Override
    public void setArms(String arms) {
       super.arms = arms;
    }

    @Override
    public void setMedia(String media) {
       super.mediaCenter = media;
    }

    @Override
    public void setPower(String power) {
       super.powerPlant= power;
    }
    
    
    
    
    
    
    
}
