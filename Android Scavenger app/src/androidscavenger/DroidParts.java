/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidscavenger;

import java.security.SecureRandom;

/**
 *
 * @author M4K3L
 */
public class DroidParts {
    
    private final String models[ ] = {"Mk1", "Mk2", "Mk3", "Mk4", "Mk5"};
    private final String brains [ ] = {"2.5GHZ", "3.5GHZ", "4.5GHZ"};
    private final String mobililties [ ] = {"Catapilar tracks", "Wheels", "Legs"};
    private final String visions [ ] = {"Heat vision", "Full color", "Night vision"};
    private final String arms [ ] = {"Claws" , "Grippers" , " Articulated fingers" };
    private final String mediaCenter [ ] = {"Sony" , "JVC" , "Meridian"};
    private final String powerPlants [ ] = {"Lithium" , "Hydrogen" , "Plasma (40 watt range)" };
    

    private SecureRandom randomGenerator = new SecureRandom(); 
    
    
    
    
    //Methods
    public String getRandomModel() {

        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.models.length);

        return this.models[randomNumber];
    }
    
    
    public String getRandomBrain() {

        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.brains.length);

        return this.brains[randomNumber];
    }

    
    public String getRandomMobility(){
        
        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.mobililties.length);

        return this.mobililties[randomNumber];
        
    }
    
    
    public String getRandomVision(){
        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.visions.length);

        return this.visions[randomNumber];
        
    }
    
    public String getRandomArms(){
        
         int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.arms.length);

        return this.arms[randomNumber];
    }
    
    public String getRandomMedia(){
        
        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.mediaCenter.length);

        return this.mediaCenter[randomNumber];
    }
    
    public String getRandomPower(){
        
        int randomNumber;

        randomNumber = this.randomGenerator.nextInt(this.powerPlants.length);

        return this.powerPlants[randomNumber];
    }
    
}
