/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidscavenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author M4K3L
 */

public class ExistingDroids extends Droids {

    // This is our hashmap for existing droids
    HashMap <Integer , ExistingDroids> existingDroidsList = new HashMap();
    
   
    //Store here particular model seperately
    ArrayList<ExistingDroids> mk1List = new ArrayList();
    ArrayList<ExistingDroids> mk2List = new ArrayList();
    ArrayList<ExistingDroids> mk3List = new ArrayList();
    ArrayList<ExistingDroids> mk4List = new ArrayList();
    ArrayList<ExistingDroids> mk5List = new ArrayList();
    
     Iterator<ExistingDroids> iterator  = mk1List.iterator(); 
      
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
