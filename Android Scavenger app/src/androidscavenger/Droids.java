package androidscavenger;

/*
* Android Scavenger is an application where you can search through inventory which contains randomly generated 400 
* new line of droids which were created by taking parts from old droid. This application is using very complex algorithm.
*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public abstract class Droids {
    
    // required parts for each Droid
    String model = " ";
    int serialNumber;
    String brain = " ";
    String mobility = " ";
    String vision = " ";
    String arms = " ";
    String mediaCenter = " ";
    String powerPlant = " ";
    
   
    //If we use abstract methods class must be declared abstract
    public abstract void setModel(String modelName);
    public abstract void setSerialNumber(int serial);
    public abstract void setBrain(String brain);
    public abstract void setMobility(String mobility);
    public abstract void setVision(String vision);
    public abstract void setArms(String arms);
    public abstract void setMedia(String media);
    public abstract void setPower(String power);
    
    
    
    // non-abstract methods
    public String getModel() {
        return model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getBrain() {
        return brain;
    }

    public String getMobility() {
        return mobility;
    }

    public String getVision() {
        return vision;
    }

    public String getArms() {
        return arms;
    }

    public String getMediaCenter() {
        return mediaCenter;
    }

    public String getPowerPlant() {
        return powerPlant;
    }

  
    
    
    
}
