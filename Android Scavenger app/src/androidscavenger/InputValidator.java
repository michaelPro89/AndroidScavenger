/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidscavenger;


/**
 *
 * @author mikemike
 */
public class InputValidator 
{
    
    //Data field
    private String [ ] checkInput = new String [4];
    private  boolean inputIsNot4Letters;
    private  boolean wrongChoice;
    private boolean checkingInput;

    
    public boolean isInputIsNot4Letters() {
        return inputIsNot4Letters;
    }

    public void setInputIsNot4Letters(boolean inputIsNot4Letters) {
        this.inputIsNot4Letters = inputIsNot4Letters;
    }

    
    public void setWrongChoice(boolean wrongChoice) {
        this.wrongChoice = wrongChoice;
    }

    public boolean isWrongChoice() {
        return wrongChoice;
    }
    
   
      
    public String checkInputLength(String userInput)
{
        //set booleans value to default everytime we use this method to check input
        this.checkingInput = true;
        this.inputIsNot4Letters = false;

        // Extracts input and checks as well if the input is not less than 4 characters 
        while (this.checkingInput) {
            try {

                //if user input is empty on one of substring 0,1,2,3 than it will force to change boolean to true
                if (userInput.substring(0, 1).equalsIgnoreCase(" ")) {
                    this.inputIsNot4Letters = true;

                } else if (userInput.substring(1, 2).equalsIgnoreCase(" ")) {
                    this.inputIsNot4Letters = true;

                    //debug
                    System.out.println("Oops i v got error ... second letter is missing in name!");

                } else if (userInput.substring(2, 3).equalsIgnoreCase(" ")) {
                    this.inputIsNot4Letters = true;

                } else if (userInput.substring(3, 4).equalsIgnoreCase(" ")) {
                    this.inputIsNot4Letters = true;

                }

              // if user input is empty and doesnt have any letters inside it will throw error because
              // if endIndex > value.length than it throws error... and it will change boolean to true as well
            } catch (Exception e) {
                this.inputIsNot4Letters = true;
            }

            this.checkingInput = false;

        }

        return userInput;
    }

    public void checkPlayerChoice(int numberOfChoices, String input)
    {
        
         this.wrongChoice = false;
       
         //Try to parse player input, if player enters nothing or enters not required number then set wrongChoice = true
         //so we can ask again for input.
         try
         {
            if (numberOfChoices == 1)
          {
              switch (input.substring(0, 1)) 
              {
                  case "1":
                      this.wrongChoice = false;
                      break;
 
                  default:
                      this.wrongChoice = true;
                      break;
              }
          }
          if (numberOfChoices == 2)
          {
              switch (input.substring(0, 1)) 
              {
                  case "1":
                      this.wrongChoice = false;
                      break;
                      
                  case "2":
                      this.wrongChoice = false;
                      break;
 
                  default:
                      this.wrongChoice = true;
                      break;
              }
          }
            if (numberOfChoices == 3)
          {
              switch (input.substring(0, 1)) 
              {
                  case "1":
                      this.wrongChoice = false;
                      break;
                      
                  case "2":
                      this.wrongChoice = false;
                      break;
                      
                   case "3":
                      this.wrongChoice = false;
                      break;
 
                  default:
                      this.wrongChoice = true;
                      break;
              }
          }
          
               if (numberOfChoices == 4)
          {
              switch (input.substring(0, 1)) 
              {
                  case "1":
                      this.wrongChoice = false;
                      break;
                      
                   case "2":
                      this.wrongChoice = false;
                      break;
                      
                     case "3":
                      this.wrongChoice = false;
                      break;
                      
                  case "4":
                      this.wrongChoice = false;
                      break;

                  default:
                      this.wrongChoice = true;
                      break;
              }
          }
               
                  if (numberOfChoices == 9)
          {
              switch (input.substring(0, 1)) 
              {
                  case "1":
                      this.wrongChoice = false;
                      break;               
                   case "2":
                      this.wrongChoice = false;
                      break;                  
                  case "3":
                      this.wrongChoice = false;
                      break;
                  case "4":
                      this.wrongChoice = false;
                      break;
                  case "5":
                      this.wrongChoice = false;
                      break;
                  case "6":
                      this.wrongChoice = false;
                      break;
                  case "7":
                      this.wrongChoice = false;
                      break;
                  case "8":
                      this.wrongChoice = false;
                      break;
                  case "9":
                      this.wrongChoice = false;
                      break;
                  default:
                      this.wrongChoice = true;
                      break;
              }
          }
               
             
         } catch (Exception e)
         {
                this.wrongChoice = true;
         }
         
   

    }
      
}

