/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidscavenger;


public class AndroidScavenger {

     
      private  String userInput = " ";
      private boolean appRuning = true;

  
    public static void main(String[] args) {
        
        //Objects
        AndroidScavenger as = new AndroidScavenger();
        SerialGenerator sNG = new SerialGenerator();
        DroidParts parts = new DroidParts();
        AppLogic logic = new AppLogic();
        ExistingDroids droids = new ExistingDroids();
        InputWindow inputW = new InputWindow("Andr@id Scav3ng3r");
        NewDroids newD = new NewDroids();
        InputValidator inputV = new InputValidator();

        //   app starts here
        sNG = logic.generateSerials(sNG);
        droids = logic.createExistingDroids(droids, parts, sNG);
        newD = logic.createNewDroids(newD, sNG, droids);
        logic.removeParts(droids, newD, sNG, 399);

        //newD = logic.removeParts(newD, sNG, droids);
        inputW.showWindow();

        while (as.isAppRuning()) {

            inputW = logic.showMenu(inputW);
            logic.getInput(inputW, as);
            logic.checkInput(inputW, inputV, as, 4);
            logic.giveOutput(inputW, as, newD, sNG, droids, inputV);
            logic.goBackMenu(inputW, as, inputV);

        }

       
    }

    
    
    //methods

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

      public boolean isAppRuning() {
        return appRuning;
    }

    public void setAppRuning(boolean appRuning) {
        this.appRuning = appRuning;
    }
    
    
    
    
}
