package androidscavenger;


import java.util.Random;

/*
* Android Scavenger is an application where you can search through inventory which contains randomly generated 400 
* new line of droids which were created by taking parts from old droid. This application is using very complex algorithm.
*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public class AppLogic {
    
    
            
    
    //Logic goes here
    public SerialGenerator generateSerials(SerialGenerator sg){
        
        sg.generateSerialNumbers();
        
        return sg;
    };
    
    
    public ExistingDroids  createExistingDroids (ExistingDroids droids, DroidParts parts, SerialGenerator sg) {

        //Here we create 500 existing droids
        for (int amount = 499; amount >= 0; amount--) {
            
            ExistingDroids ex = new ExistingDroids();

            ex.setModel(parts.getRandomModel());
            ex.setBrain(parts.getRandomBrain());
            ex.setMobility(parts.getRandomMobility());
            ex.setVision(parts.getRandomVision());
            ex.setArms(parts.getRandomArms());
            ex.setSerialNumber(sg.getSerial(amount));
            ex.setPower(parts.getRandomPower());
            ex.setMedia(parts.getRandomMedia());

            // Put every droid object with different parts setup into our HashMap list
            droids.existingDroidsList.put(amount, ex);

        }

        //Return our droids object
        return droids;
    };

        
    public NewDroids createNewDroids(NewDroids newD, SerialGenerator sg, ExistingDroids droids){

        //Here we create 400 NEW droids objects
        for (int amount = 399; amount >= 0; amount--) {

            NewDroids nd = new NewDroids();
            
             //Set only model and serial ovehere, then set parts in method 'removeParts'
            nd.setModel(newD.getRandomModel());
            nd.setSerialNumber(sg.getSerial(amount));
         
            
            // Put every droid object  into our HashMap list
            newD.newDroidsList.put(amount, nd);

        }

        return newD;
    };
    
    
    
    public void test(NewDroids newD, ExistingDroids droids) {

        // Extract existing droid and new droid into an objects so we can access their data
        for (int index = 399; index >= 0; index--) {

            NewDroids nd = newD.newDroidsList.get(index);
            System.out.println(" ");
            System.out.println("The serial number of new droid is : " + nd.getSerialNumber());
            System.out.println("The model of new droid is : " + nd.getModel());
            System.out.println("The arms of new droid  is : " + nd.getArms());
            System.out.println("The  brain of new model  is : " + nd.getBrain());
            System.out.println("The mobility of new droid  is : " + nd.getMobility());
            System.out.println("The power plant of new droid  is : " + nd.getPowerPlant());
            System.out.println("The media of new model is : " + nd.getMediaCenter());
            System.out.println("The vision of new droid is : " + nd.getVision());
            System.out.println(" ");
        }

    }

    public InputWindow showMenu ( InputWindow input){
        
     
        input.addText("What do you want to do ? :");
        input.nextLine();
         input.nextLine();
        input.addText("1.  Show available models of a particular type. (eg. View all Betty the Busibot models)\n\n"
                + "2. Show one model of a particular type (eg. Single Andy the Android)\n\n"
                + "3. Show total counts of available types (eg how many Andy, how many Betty…etc.)\n\n"
                + "4. Show  model that donated a particular part (ie. output of donor model and part donated and receiving model)");
         
         input.scrollDown();
         
        return input;
    }
    
    
    public void getInput( InputWindow input, AndroidScavenger as){
        
          //ask user to choose option
        as.setUserInput(input.waitForPlayerInput("Choose your option and enter below :  "));

        
    }
    
    
    
    public void checkInput(InputWindow input, InputValidator inValidator, AndroidScavenger as, int options) {

        inValidator.checkPlayerChoice(options, as.getUserInput());

        while (inValidator.isWrongChoice()) {
            as.setUserInput(input.waitForPlayerInput("Wrong input. You have to choose available option. "));
            inValidator.checkPlayerChoice(options, as.getUserInput());
        }
         
        input.nextLineWithSeparators();
        input.scrollDown();

    }

    public void giveOutput(InputWindow input, AndroidScavenger as, NewDroids newD, SerialGenerator sg, ExistingDroids droids, InputValidator inValidator){
        
             
        if(as.getUserInput().substring(0, 1).equalsIgnoreCase("1")){
            
            input.addText("What type of models do you want to display ? :");
            input.nextLine();
            input.nextLine();
            input.addText("1.  All mk1 models.");
            input.nextLine();
            input.addText("2.  All mk2 models.");
            input.nextLine();
            input.addText("3.  All mk3 models.");
            input.nextLine();
            input.addText("4.  All mk4 models.");
            input.nextLine();
            input.addText("5.  All mk5 models.");
            input.nextLine();
            input.addText("6.  All Andy The Android models.");
            input.nextLine();
            input.addText("7.  All  Betty The Busibot models.");
            input.nextLine();
            input.addText("8.  All Bobi The Racedroid models.");
            input.nextLine();
            input.addText("9.  All Fred The Friendlybot models.");
            input.scrollDown();
            
           getInput ( input,  as);
           checkInput(input, inValidator,  as, 9);
           sortModels(newD,droids);
           getAllModels( as, newD, droids,  input);

        } else if (as.getUserInput().substring(0, 1).equalsIgnoreCase("2")){
             
            input.addText("What particular model do you want to display ? :");
            input.nextLine();
            input.nextLine();
            input.addText("1.  Model mk1.");
            input.nextLine();
            input.addText("2.  Model mk2.");
            input.nextLine();
            input.addText("3.  Model mk3.");
            input.nextLine();
            input.addText("4.  Model mk4.");
            input.nextLine();
            input.addText("5.  Model mk5.");
            input.nextLine();
            input.addText("6.  Model Andy The Android.");
            input.nextLine();
            input.addText("7.  Model Betty The Busibot.");
            input.nextLine();
            input.addText("8. Model Bobi The Racedroid.");
            input.nextLine();
            input.addText("9.  Model Fred The Friendlybot.");
            input.scrollDown();
            
            getInput(input, as);
            checkInput(input, inValidator, as, 9);           
            sortModels(newD, droids);
            getSingleModel( as, newD, droids,  input);
         
          
        } else if(as.getUserInput().substring(0, 1).equalsIgnoreCase("3")){
            
             getModelsCount(newD, sg, droids, input);
  

         
        } else if(as.getUserInput().substring(0, 1).equalsIgnoreCase("4")){
            
                    
            input.addText("Pick one receiving model  :");
            input.nextLine();
            input.nextLine();
            input.addText("1.  Model Andy The Android.");
            input.nextLine();
            input.addText("2.  Model Betty The Busibot.");
            input.nextLine();
            input.addText("3. Model Bobi The Racedroid.");
            input.nextLine();
            input.addText("4.  Model Fred The Friendlybot.");
            input.scrollDown();
            
            getInput(input, as);
            checkInput(input, inValidator, as, 4);
            sortModels(newD, droids);
            getDonorModel(as, newD, droids, input, inValidator);


        }

    

    }
    
    public void getDonorModel(AndroidScavenger as,NewDroids newD,  ExistingDroids droids, InputWindow input, InputValidator inValidator){
    
          //Local variables and objects
        Random rg = new Random();
        String modelName = as.getUserInput();
        ExistingDroids ex;
        NewDroids nd;

        switch (modelName) {

            //Andy
            case "1":
                
                //get random object from list
                nd = newD.andyList.get(rg.nextInt(newD.andyList.size()));
                
                input.addText("Which part donated you want to dispaly ? :");
                input.nextLine();
                input.nextLine();
                input.addText("1.  Brain.");
                input.scrollDown();
                
            getInput(input, as);
            checkInput(input, inValidator, as, 1);

                if (as.getUserInput().substring(0, 1).equalsIgnoreCase("1")) {
                    
                    //Pass randomly generated newDroid object and find donor model
                    getDonatedPart(nd,droids,input,1);
                    
                } 


                break;
                
            //Betty              
            case "2":
                
                          //get random object from list
                nd = newD.bettyList.get(rg.nextInt(newD.bettyList.size()));
                
                input.addText("Which part donated you want to dispaly ? :");
                input.nextLine();
                input.nextLine();
                input.addText("1.  Brain.");
                input.scrollDown();
                
            getInput(input, as);
            checkInput(input, inValidator, as, 1);

                if (as.getUserInput().substring(0, 1).equalsIgnoreCase("1")) {
                    
                    //Pass randomly generated newDroid object and find donor model
                    getDonatedPart(nd,droids,input,1);
                    
                } 


                break;

            //Bobi              
            case "3":

                //get random object from list
                nd = newD.bobiList.get(rg.nextInt(newD.bobiList.size()));

                input.addText("Which part donated you want to dispaly ? :");
                input.nextLine();
                input.nextLine();
                input.addText("1.  Brain.");
                input.scrollDown();

            getInput(input, as);
            checkInput(input, inValidator, as, 1);

                if (as.getUserInput().substring(0, 1).equalsIgnoreCase("1")) {
                    
                    //Pass randomly generated newDroid object and find donor model
                    getDonatedPart(nd,droids,input,1);
                    
                } 


                break;
      
            //Fredy   
            case "4":

                //get random object from list
                nd = newD.fredList.get(rg.nextInt(newD.fredList.size()));

                input.addText("Which part donated you want to dispaly ? :");
                input.nextLine();
                input.addText("1.  Brain.");
                input.scrollDown();

                getInput(input, as);
                checkInput(input, inValidator, as, 1);

                if (as.getUserInput().substring(0, 1).equalsIgnoreCase("1")) {

                    //Pass randomly generated newDroid object and find donor model
                    getDonatedPart(nd, droids, input, 1);

                }

                break;

    }
    }
    
    
    public void getDonatedPart(NewDroids nd,  ExistingDroids droids, InputWindow input, int part) {

        String searchingPart = "";
        String serialNumber = "";
 
        switch (part) {
            
            //brain part overhere
            case 1:

                searchingPart = nd.getBrain();

                 //this works
                String[] array = searchingPart.split(" ", 0);
                
                //debug       
                System.out.println("the serial should be here : " + array[array.length - 2]);
                System.out.println("searching part full string  : " + searchingPart);

                //Here should be a serial number
                serialNumber = array[array.length-2];
                
                //Convert from String to int
                int number = Integer.parseInt(serialNumber);

                for (int amount = 499; amount >= 0; amount--) {

                    //Lets start the seeearch!
                    ExistingDroids ex = droids.existingDroidsList.get(amount);

                    if (ex.getSerialNumber() == number) {

                        input.nextLine();
                        input.addText("The donor model is : ");
                        input.nextLine();
                        input.nextLine();
                        input.addText("Model name : " + ex.getModel());
                        input.nextLine();
                        input.addText("Serial number  : " + ex.getSerialNumber());
                        input.nextLine();
                        input.addText("Arms  : " + ex.getArms());
                        input.nextLine();
                        input.addText("Mobility : " + ex.getMobility());
                        input.nextLine();
                        input.addText("Vision : " + ex.getVision());
                        input.nextLine();
                        input.addText("Media center : " + ex.getMediaCenter());
                        input.nextLine();
                        input.addText("Power Plant : " + ex.getPowerPlant());
                        input.nextLine();
                        input.addText("Brain : " + ex.getBrain());
                        
                        input.nextLine();
                        input.nextLine();
                        input.addText("The receiving model is : ");
                        input.nextLine();
                        input.nextLine();
                        input.addText("Model name : " + nd.getModel());
                        input.nextLine();
                        input.addText("Serial number  : " + nd.getSerialNumber());
                        input.nextLine();
                        input.addText("Arms  : " + nd.getArms());
                        input.nextLine();
                        input.addText("Mobility : " + nd.getMobility());
                        input.nextLine();
                        input.addText("Vision : " + nd.getVision());
                        input.nextLine();
                        input.addText("Media center : " + nd.getMediaCenter());
                        input.nextLine();
                        input.addText("Power Plant : " + nd.getPowerPlant());
                        input.nextLine();
                        input.addText("Brain : " + nd.getBrain());
                        input.nextLineWithSeparators();

                        break;
                    }

                }


                break;

            case 2:
                   //No time for it ;) xD
                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;
     
         }

    }

    
    
    public void goBackMenu(InputWindow input, AndroidScavenger as, InputValidator inValidator){
        
        //Ask if user wants to quit app or go back to main menu
        input.nextLine();
        input.addText("Do you want to go back to menu ? :");
        input.nextLine();
        input.nextLine();
        input.addText("1. Yes.");
        input.nextLine();
        input.addText("2. No (exit program).");
        input.scrollDown();

        getInput(input,as);
        checkInput(input,  inValidator, as, 2) ;
        
        if (as.getUserInput().substring(0, 1).equalsIgnoreCase("1")) {

            as.setAppRuning(true);

        } else {
            System.exit(0);
        }
        
    }
  
    
   
    public void getModelsCount(NewDroids newD, SerialGenerator sg, ExistingDroids droids, InputWindow input){
  
        int mk1 = 0;
        int mk2 = 0;
        int mk3 = 0;
        int mk4 = 0;
        int mk5 = 0;
        int betty = 0;
        int fred = 0;
        int bobi = 0;
        int andy = 0;

        // Extract existing droid and new droid into an objects so we can access their data
        for (int index = 499; index >= 0; index--) {

            ExistingDroids ex = droids.existingDroidsList.get(index);


            switch (ex.getModel()) {

                case "Mk1":
                    mk1++;
                    break;
                case "Mk2":
                    mk2++;
                    break;
                case "Mk3":
                    mk3++;
                    break;
                case "Mk4":
                    mk4++;
                    break;
                case "Mk5":
                    mk5++;
                    break;
            }

        }

        //Do the same thing for new droids here
        for (int index = 399; index >= 0; index--) {

            NewDroids nd = newD.newDroidsList.get(index);


            switch (nd.getModel()) {
                //{"Andy The Android", "Betty The Busibot", "Bobi The Racedroid", "Fred The Friendlybot"};
                case "Andy The Android":
                    andy++;
                    break;
                case "Betty The Busibot":
                    betty++;
                    break;
                case "Bobi The Racedroid":
                    bobi++;
                    break;
                case "Fred The Friendlybot":
                    fred++;
                    break;
            }

        }

       
        input.addText("Total count of Fred The Friendlybot is : " + fred);
        input.nextLine();
        input.addText("Total count of Betty The Busibot is : " + betty);
        input.nextLine();
        input.addText("Total count of Bobi The Racedroid is : " + bobi);
        input.nextLine();
        input.addText("Total count of Andy The Android is : " + andy);
        input.nextLine();
        input.addText("total count of Mk1 is : " + mk1);
        input.nextLine();
        input.addText("total count of Mk2 is : " + mk2);
        input.nextLine();
        input.addText("total count of Mk3 is : " + mk3);
        input.nextLine();
        input.addText("total count of Mk4 is : " + mk4);
        input.nextLine();
        input.addText("total count of Mk5 is : " + mk5);

    }

  
    public void getSingleModel (AndroidScavenger as,NewDroids newD,  ExistingDroids droids, InputWindow input){
        
        //Local variables and objects
        Random rg = new Random();
        String modelName = as.getUserInput();
        ExistingDroids ex;
        NewDroids nd;

        switch (modelName) {

            case "1":

                  ex = droids.mk1List.get(rg.nextInt(droids.mk1List.size()));

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

   
                break;
                
            case "2":


                    ex = droids.mk2List.get(rg.nextInt(droids.mk2List.size()));

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                break;
                
            case "3":

                  ex = droids.mk3List.get(rg.nextInt(droids.mk3List.size()));
                  
                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

     
                break;
            case "4":

                ex = droids.mk4List.get(rg.nextInt(droids.mk4List.size()));

                input.addText("Model name : " + ex.getModel());
                input.nextLine();
                input.addText("Serial number  : " + ex.getSerialNumber());
                input.nextLine();
                input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                break;

            case "5":

               ex = droids.mk5List.get(rg.nextInt(droids.mk5List.size()));

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                break;

            case "6":

                  nd = newD.andyList.get(rg.nextInt(newD.andyList.size()));

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                break;

            case "7":

                 nd = newD.bettyList.get(rg.nextInt(newD.bettyList.size()));

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                break;

            case "8":

                 nd = newD.bobiList.get(rg.nextInt(newD.bobiList.size()));

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                break;

            case "9":

                  nd = newD.fredList.get(rg.nextInt(newD.fredList.size()));

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                break;
                
        }
    }
        
    public void getAllModels(AndroidScavenger as, NewDroids newD, ExistingDroids droids, InputWindow input) {

        String modelName = as.getUserInput();

        switch (modelName) {

            case "1":

                for (int index = 0; index < droids.mk1List.size(); index++) {

                    ExistingDroids ex = droids.mk1List.get(index);

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                }

                break;
            case "2":

                for (int index = 0; index < droids.mk2List.size(); index++) {

                    ExistingDroids ex = droids.mk2List.get(index);

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                }

                break;
            case "3":

                for (int index = 0; index < droids.mk3List.size(); index++) {

                    ExistingDroids ex = droids.mk3List.get(index);

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                }

                break;
            case "4":

                for (int index = 0; index < droids.mk4List.size(); index++) {

                    ExistingDroids ex = droids.mk4List.get(index);

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                }

                break;

            case "5":

                for (int index = 0; index < droids.mk5List.size(); index++) {

                    ExistingDroids ex = droids.mk5List.get(index);

                    input.addText("Model name : " + ex.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + ex.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + ex.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + ex.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + ex.getVision());
                    input.nextLine();
                    input.addText("Media center : " + ex.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + ex.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + ex.getBrain());
                    input.nextLineWithSeparators();

                }

                break;

            case "6":

                for (int index = 0; index < newD.andyList.size(); index++) {

                    NewDroids nd = newD.andyList.get(index);

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                }

                break;

            case "7":

                for (int index = 0; index < newD.bettyList.size(); index++) {

                    NewDroids nd = newD.bettyList.get(index);

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                }

                break;

            case "8":

                for (int index = 0; index < newD.bobiList.size(); index++) {

                    NewDroids nd = newD.bobiList.get(index);

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                }

                break;

            case "9":

                for (int index = 0; index < newD.fredList.size(); index++) {

                    NewDroids nd = newD.fredList.get(index);

                    input.addText("Model name : " + nd.getModel());
                    input.nextLine();
                    input.addText("Serial number  : " + nd.getSerialNumber());
                    input.nextLine();
                    input.addText("Arms  : " + nd.getArms());
                    input.nextLine();
                    input.addText("Mobility : " + nd.getMobility());
                    input.nextLine();
                    input.addText("Vision : " + nd.getVision());
                    input.nextLine();
                    input.addText("Media center : " + nd.getMediaCenter());
                    input.nextLine();
                    input.addText("Power Plant : " + nd.getPowerPlant());
                    input.nextLine();
                    input.addText("Brain : " + nd.getBrain());
                    input.nextLineWithSeparators();

                }

                break;

        }


    }
     

    public void sortModels(NewDroids newD,  ExistingDroids droids){

     
         for (int index = 399; index >= 0; index--) {

            NewDroids nd = newD.newDroidsList.get(index);

            switch (nd.getModel()) {

                case "Andy The Android":
                    newD.andyList.add(nd);
                    break;
                case "Betty The Busibot":
                    newD.bettyList.add(nd);
                    break;
                case "Bobi The Racedroid":
                    newD.bobiList.add(nd);
                    break;
                case "Fred The Friendlybot":
                    newD.fredList.add(nd);
                    break;

            }

        }
        
          
        for (int index = 499; index >= 0; index--) {

            ExistingDroids ex = droids.existingDroidsList.get(index);

            switch (ex.getModel()) {

                case "Mk1":
                    droids.mk1List.add(ex);
                    break;
                case "Mk2":
                     droids.mk2List.add(ex);
                    break;
                case "Mk3":
                    droids.mk3List.add(ex);
                    break;
                case "Mk4":
                    droids.mk4List.add(ex);
                    break;
                case "Mk5":
                    droids.mk5List.add(ex);
                    break;

            }

        }

    }
    
    public void removeParts(ExistingDroids droids, NewDroids newD, SerialGenerator sg, int amount) {

        // Bring partsSet & indexOfNewDroids out of the for loops so it will be manipulated later on inside for loop
        int partsSet = 0;
        int indexOfNewDroids = amount;
        int counter = 0;
        
        
         //Remove parts here
         
        for (int indexOfOldDroids = 499; indexOfOldDroids >= 0; indexOfOldDroids--) {
            
                   
            ExistingDroids ex = droids.existingDroidsList.get(indexOfOldDroids);

            for (; indexOfNewDroids >= 0; indexOfNewDroids--) {

                // Count removed - set to 0 with each loop iteration
                int removed = 0;

                
                NewDroids nd = newD.newDroidsList.get(indexOfNewDroids);

                if (removed != 2 && removed < 2) {

                    // if part is not set yet for new droid and part from old droid is not yet removed - set it overhere
                    if (nd.getArms().equalsIgnoreCase((" ")) && !ex.getArms().equalsIgnoreCase("Removed")) {
                        
              
                        //Set new part
                        nd.setArms(ex.getArms() +" ( " +ex.getModel() + " "+ex.getSerialNumber() + " ) ");
                        //Set removed
                        ex.setArms("Removed");
                        //Count remove
                        removed++;
                        //Count number of parts thats have been set already for each new droid object
                        partsSet++;

                    }
                    // If we have already removed 2 parts from old droid then break out the inner for-loop
                } else {

                    
                    break;
                }

                if (removed != 2 && removed < 2) {

                    // if part is not set yet for new droid and part from old droid is not yet removed - set it overhere
                    if (nd.getBrain().equalsIgnoreCase((" ")) && !ex.getBrain().equalsIgnoreCase("Removed")) {
                   
                        //Set new part
                        nd.setBrain(ex.getBrain() + " ( " +ex.getModel() + " " + ex.getSerialNumber()+" ) ");
                        //Set removed
                        ex.setBrain("Removed");
                        //Count remove
                        removed++;
                        //Count number of parts thats have been set already for each new droid object
                        partsSet++;

                    }
                    // If we have already removed 2 parts from old droid then break out the inner for-loop
                } else {
         
                    break;
                }

                if (removed != 2 && removed < 2) {

                    // if part is not set yet for new droid and part from old droid is not yet removed - set it overhere
                    if (nd.getMediaCenter().equalsIgnoreCase((" ")) && !ex.getMediaCenter().equalsIgnoreCase("Removed")) {

                         
                        //Set new part
                        nd.setMedia(ex.getMediaCenter()+ " ( " +ex.getModel() + " " + ex.getSerialNumber()+" ) ");
                        //Set removed
                        ex.setMedia("Removed");
                        //Count remove
                        removed++;
                        //Count number of parts thats have been set already for each new droid object
                        partsSet++;

                    }
                    // If we have already removed 2 parts from old droid then break out the inner for-loop
                } else {
                    
                    break;
                }

                if (removed != 2 && removed < 2) {

                    // if part is not set yet for new droid and part from old droid is not yet removed - set it overhere
                    if (nd.getMobility().equalsIgnoreCase((" ")) && !ex.getMobility().equalsIgnoreCase("Removed")) {

                          
                        //Set new part
                        nd.setMobility(ex.getMobility() + " ( " +ex.getModel() + " " + ex.getSerialNumber()+" ) ");
                        //Set removed
                        ex.setMobility("Removed");
                        //Count remove
                        removed++;
                        //Count number of parts thats have been set already for each new droid object
                        partsSet++;

                    }
                    // If we have already removed 2 parts from old droid then break out the inner for-loop
                } else {
                 
                    break;
                }

                if (removed != 2 && removed < 2) {

                    // if part is not set yet for new droid and part from old droid is not yet removed - set it overhere
                    if (nd.getPowerPlant().equalsIgnoreCase((" ")) && !ex.getPowerPlant().equalsIgnoreCase("Removed")) {

                    
                        //Set new part
                        nd.setPower(ex.getPowerPlant()  + " ( " +ex.getModel() + " " + ex.getSerialNumber()+" ) ");
                        //Set removed
                        ex.setPower("Removed");
                        //Count remove
                        removed++;
                        //Count number of parts thats have been set already for each new droid object
                        partsSet++;

                    }
                    // If we have already removed 2 parts from old droid then break out the inner for-loop
                } else {
          
                    break;
                }

                if (removed != 2 && removed < 2) {

                    // if part is not set yet for new droid and part from old droid is not yet removed - set it overhere
                    if (nd.getVision().equalsIgnoreCase((" ")) && !ex.getVision().equalsIgnoreCase("Removed")) {

                    
                        //Set new part
                        nd.setVision(ex.getVision() + " ( " +ex.getModel() + " " +  ex.getSerialNumber()+" ) ");
                        //Set removed
                        ex.setVision("Removed");
                        //Count remove
                        removed++;
                        //Count number of parts thats have been set already for each new droid object
                        partsSet++;

                    }
                    // If we have already removed 2 parts from old droid then break out the inner for-loop
                } else {
                  
                    break;
                }

                
                //check if all parts has been set for each object here
                if (partsSet == 6) {
  
 
                    // save every time indexOfOldDroids here
                    int currentIndex = indexOfOldDroids;

                    counter++;

                    //reset parts set
                    partsSet = 0;
                    
                    //Get new droid object in next for loop iteration
                    indexOfNewDroids--;

                    switch (counter) {

                        case 3:

                            // should be 497 after iteration -1
                            indexOfOldDroids = currentIndex;
                      
                            break;

                        default:

                            //should be 497 + 3 = 500
                            indexOfOldDroids = currentIndex + 3;

                            break;

                    }
                    
                    break;
                    
                } else {

                    //break out of inner for loop and do -1 for outer loop to get another old droid object
                    break;
                }
                
            }
        }

    }

}



