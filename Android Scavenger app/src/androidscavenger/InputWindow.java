package androidscavenger;

/*****************************************************************
 Author: Michal Switala
 Date: 2018/10/16
 Version:   3
 References: 

 https://www.youtube.com/watch?v=FLkOX4Eez6o 
 - shows how to create window in Java using the simpliest way
 
 https://www.youtube.com/watch?v=5KyYAsYvLjs&list=PLS1QulWo1RIa
 UGP446_pWLgTZPiFizEMq&index=3
 
 https://www.youtube.com/watch?v=rT-J-0nGyzU&t=507s
 
 https://docs.oracle.com/javase/tutorial/uiswing/examples/
 components/TopLevelDemoProject/src/components/TopLevelDemo.java
 - How to create window with menu and yellow backgorund
 
 https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#GlassPaneDemo
 - Here you can find all java examples explaining everything with download
 
 https://docs.oracle.com/javase/8/javafx/layout-tutorial/style_css.htm#JFXLY161
 - styling Layout Panes with CSS
 
 https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html
 - How to use Actions, for ex. how to create new actions when you hit a key on keyboard
 
 https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html
 - How to use key bindings on your keyboard to do something, for example how to bind key ENTER and set an action for it
 ****************************************************************/

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.util.Scanner;
import javax.swing.ImageIcon;

//stage is our subclass or extended class and Jframe is superclass or also so called "base class"

//A subclass inherits all the members (fields, methods, and nested classes) from its superclass
//so we can use their methods for example. 
//Constructors are not members, so they are not inherited by subclasses, but the constructor of the 
//superclass can be invoked from the subclass.

public class InputWindow implements ActionListener
{

    // Create here fields of data & objects
    //Scanner
    Scanner scanner;
    
    //creating top-level container JFrame
    JFrame window;
    
    //add 3 labels and make them centered inside your window
    JLabel labelTop;
    JLabel labelBottom;
    
    //You need to create new GridBagLayout within JPanel (Container) so you can create your new Grid(Display area).
    JPanel mainPanel;
    JPanel buttonPanel;
    
    //The GridBagConstraints specifies where a component's display area should be located 
    GridBagConstraints c;
    
    //Creates new Font object with default settings
    Font newFont;
    
    //create textarea
    JTextArea textArea;
    
    //create new buttons
    JButton buttonEnter;
    JButton buttonExit;
    
    //Object to receive user input
    JTextField userInput;
    
    //Create JScrollPane
    JScrollPane scrollbar;
    
    //Borders
    Border myBorder;
    
    //Pause variable
    private boolean pause = true;
    private boolean playerInputEmpty = true;
    
   final Color BACKGROUND_COLOR = new Color(89, 89, 89);
    final Color TEXTAREA_COLOR = new Color(0,0,0);
    final Color BUTTON_COLOR = new Color (89, 89, 89);
    final Color TEXT_COLOR = new Color (191, 255, 0);
    
    // Constructor
    InputWindow(String title)
    {
    
    //Instantiate new objects
    window = new JFrame(title);
     ImageIcon icon = createImageIcon("arcadia logo.png", "logo");
    labelTop =  new JLabel(icon);
    labelBottom  = new JLabel("Do you want to play a game ? ", JLabel.CENTER);
    mainPanel  = new JPanel(new GridBagLayout());
    buttonPanel  = new JPanel(new BorderLayout());
    c = new GridBagConstraints();
    newFont = new Font("Century Gothic", Font.BOLD, 29);
    buttonEnter  = new JButton("Enter");
    buttonExit  = new JButton("Exit");
    userInput =  new JTextField("enter here",15);
    myBorder  = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    textArea = new JTextArea();
    scrollbar = new JScrollPane(textArea);
   
 
   //Here we instantiate new actions used when we press ENTER or ESCAPE on keyboard
        Action enterPressed= new AbstractAction() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // method "doClick"  does work as if you have just clicked the button
                    buttonEnter.doClick(20);
                 
                }
            };
            
    Action escapePressed= new AbstractAction() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    
                    buttonExit.doClick(20);
       
                }
            };
    // "enterPressed" are javax.swing.Action objects
    // This code adds key "ENTER"  and name of action "enterPressed" to the inputMap
    // "WHEN_IN_FOCUSED_WINDOW" is used to react to pressed key no matter where the focus is
     buttonEnter.getInputMap(buttonEnter.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "enterPressed");
      // This code adds key "ESCAPE"  and name of action "enterPressed" to the inputMap
     buttonExit.getInputMap(buttonExit.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"escapePressed");
     
    //Here we add our action to action map
    buttonEnter.getActionMap().put("enterPressed", enterPressed);
    buttonExit.getActionMap().put("escapePressed", escapePressed);
    
    //This code prevents key "SPACE" to react on Enter button and Exit button
    buttonEnter.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    buttonExit.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    
    //Here we set vertical bar to be displayed always and horizontal scrollbar never
    scrollbar.setHorizontalScrollBarPolicy(scrollbar.HORIZONTAL_SCROLLBAR_NEVER);
    scrollbar.setVerticalScrollBarPolicy(scrollbar.VERTICAL_SCROLLBAR_ALWAYS);
    
    //adding action listeners and setting up names of action commands
    //so we will identify which button has been clicked and add proper code to it
    buttonEnter.addActionListener(this);
    buttonEnter.setActionCommand("Enter");
    buttonExit.addActionListener(this);
    buttonExit.setActionCommand("Exit");
        
    //Change settings of Components here
    textArea.setBorder(myBorder);
    userInput.setBorder(myBorder);
    buttonPanel.setPreferredSize(new Dimension(170,26));
     
    //Change settings of window here (JFrame)
    window.setSize(500,660); // (width, height)
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
    //changed background color of the panel
    mainPanel.setBackground(this.BACKGROUND_COLOR);
    buttonPanel.setBackground(this.BACKGROUND_COLOR);
    
  
    //Here change settings of textField
    textArea.setBackground(this.TEXTAREA_COLOR);
    textArea.setForeground(this.TEXT_COLOR);
    //If we add a scrollbar to panel we then set size of our scrollbar instead of panel
    scrollbar.setPreferredSize(new Dimension(410,350));
    scrollbar.setVisible(true);
    //Makes textArea unable to edit 
    textArea.setEditable(false);
    //Makes textArea content will always fit inside textArea width
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(new Font("Century Gothic", Font.BOLD, 15));
     
    //Change size of Buttons
    buttonEnter.setPreferredSize(new Dimension(75,26));
    buttonEnter.setForeground(this.TEXT_COLOR);
    buttonEnter.setBackground(this.BUTTON_COLOR);
        
    buttonExit.setPreferredSize(new Dimension(75,26));
    buttonExit.setForeground(this.TEXT_COLOR);
    buttonExit.setBackground(this.BUTTON_COLOR);
    
    //Set font of Labels
    labelTop.setPreferredSize(new Dimension(160,90));
    labelTop.setFont(new Font("Century Gothic", Font.BOLD, 20));
    labelBottom.setFont(new Font("Century Gothic", Font.BOLD, 20));
    labelBottom.setForeground(this.TEXT_COLOR);
    
    c.weighty = 0.2;
    c.ipady = 9;
    // Make the component fill its display area entirely 
    //in this case labelTop, scrollbar and labelBottom
    c.fill= c.BOTH;

    //Change grids before adding labels
    c.gridy =0;
    mainPanel.add(labelTop, c);
    c.gridy = 1;
    mainPanel.add(scrollbar, c);
    c.gridy = 2;
    mainPanel.add(labelBottom, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;         
    c.gridy = 3;

    userInput.setPreferredSize(new Dimension(10,20));
    mainPanel.add(userInput, c);
    
    labelBottom.setFont(new Font("Century Gothic", Font.BOLD, 16));
    labelBottom.setText("Default text");
    c.fill = GridBagConstraints.BASELINE;
    
    // create new panel and add buttons to it, then add this new panel2 to panel1
    // then add panel2 to panel with a Grid so we can center it all vertically
    buttonPanel.add(buttonEnter,BorderLayout.WEST);
    buttonPanel.add(buttonExit,BorderLayout.EAST);       // <-- adding buttons like this, will make them position from left to right by default
    
    //if you want to arrange positions of components  in JPanel
    //You have to add(new BorderLayout to the JPanel)
    c.gridy = 4;
    //Do not resize the component, in this case buttonPanel. 
    c.fill= c.NONE;
    mainPanel.add(buttonPanel,c);
    
    //Add panel to the frame
    window.getContentPane().add(mainPanel);
    //Displays our window (JFrame) in the center of display screen
    window.setLocationRelativeTo( null );
    window.setResizable(false);
    }

        /*********************************************************************
        * 
        *   List of all methods:
        *   ___________________
        *
        *   public void actionPerformed(ActionEvent e);
        * 
        *   public synchronized String waitForPlayerInput(String message);
        * 
        *   public void scrollDown();
        *          
        *   public void windowTitle(String);   
        *
        *   public void showWindow();
        *
        *   public void changeFont(String fontName, int fontSize);
        *
        *   public void clearWindow();
        *
        *   public void addText(String text);
        *
        *********************************************************************/
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //if you click button "No", then there will be set Action "No" so it will execute System.exit(0), but if you click "Yes" it will clear the text inside textField.
            if ("Exit".equals(e.getActionCommand())) {

                System.exit(0);

                ///If "Enter"
            } else if ("Enter".equals(e.getActionCommand())) {

                realeseTheLock();

                //fill up the code to get input....]
            }
     
        }
        
           public synchronized String waitForPlayerInput(String message)
			
    {

        labelBottom.setText(message);

        while (this.playerInputEmpty) {

            try {

                wait();

            } catch (InterruptedException e) {
            }

        }

        this.playerInputEmpty = true;
        //When released lock do this...
        String input;
        input = userInput.getText();

        return input;
    }
		
    public synchronized void realeseTheLock() {
        // notify all threads that are waiting that there's been a change
        notifyAll();
        this.playerInputEmpty = false;

    }
    
    
    public void setMessage(String message)
    {
          labelBottom.setText(message);
    }
    
    
        public void scrollDown()
        {
            
               this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
               
        }
        
        public void nextLine()
        {
            this.textArea.append("\n");
        }
        
        public void nextLineWithSeparators()
        {
            this.textArea.append("\n");
            this.textArea.setTabSize(11);
            this.textArea.append("\t*  *  *");
            this.textArea.append("\n");
        }
        
          public void separateLines()
        {
            this.textArea.append("\n");
            this.textArea.append("*******************************************************");
            this.textArea.append("\n");
        }
        
            public void appendTabSizeAt(int tabsize)
        {
            this.textArea.setTabSize(tabsize);
            this.textArea.append("\t");
        }   
        
        public void setFontRed()
        {
            this.textArea.setForeground(new Color(255, 0, 0));     
        }
        
        public void setFontOrange()
        {
            this.textArea.setForeground(new Color(255, 165, 0));     
        }
        
        public void setFontYellow()
        {
            this.textArea.setForeground(new Color(255, 255, 0));     
        }
          
        public void setFontGreen()
        {
            this.textArea.setForeground(new Color(0, 128, 0));     
        }
        
        public void setFontBrown()
        {
            this.textArea.setForeground(new Color(102, 51, 0));     
        }
        
         public void setFontIndigo()
        {
            this.textArea.setForeground(new Color(75, 0, 130));     
        }
         
         public void setFontWhite()
        {
            this.textArea.setForeground(new Color(255, 255, 130));     
        }
         
        public void setFontViolet()
        {
            this.textArea.setForeground(new Color(102, 0, 102));     
        }
   
        public void pause(int time)
        {
        //Pass int with value "20000000" to pause for around 2 hours and then executes whats after it
            try { 
                Thread.sleep(time);
                }
            catch (Exception e){} 
        }
        
        public void windowTitle(String title)
        {
            this.window.setTitle(title);
        }
        
        public void showWindow()
        {
            this.window.setVisible(true);
        }
        
        public void changeFont(String fontName, int fontSize)
        {
      
            this.textArea.setFont(new Font(fontName, Font.BOLD, fontSize));
        
        }
       
       public void clearWindow()
       {
            this.textArea.setText(" ");
       }
  
        public void addText(String text)
        {   
          
            this.textArea.append(text);
            //specifies the vertical alignment of the component to 1.
         
        }  
        
    public void ubuntuStyledText(String text) {
        String mytext = text;

        for (int l = 0; l < mytext.length(); l++) {

            this.textArea.append(mytext.substring(l, l + 1));

            pause(50);

        }

    }
        
    
     public void loading() 
     {
        for (int loop = 0; loop < 4; loop++) 
        {
            this.labelBottom.setText("LOADING game world      ");
            pause(500);
            this.labelBottom.setText("LOADING game world .    ");
            pause(500);
            this.labelBottom.setText("LOADING game world . .  ");
            pause(500);
            this.labelBottom.setText("LOADING game world . . .");
            pause(500);
        }

    }
     
        
        public void setColorRed()
        {
        this.mainPanel.setBackground(new Color(255, 0, 0));
        this.buttonPanel.setBackground(new Color(255, 0, 0));
        }
        
        public void setColorOrange()
        {
        this.mainPanel.setBackground(new Color(255, 165, 0));
        this.buttonPanel.setBackground(new Color(255, 165, 0));
        }
        
        public void setColorYellow()
        {
        this.mainPanel.setBackground(new Color(255, 255, 0));
        this.buttonPanel.setBackground(new Color(255, 255, 0));
        }
        
        public void setColorGreen()
        {
        this.mainPanel.setBackground(new Color(0, 128, 0));
        this.buttonPanel.setBackground(new Color(0, 128, 0));
        }
        
        public void setColorBrown()
        {
        this.mainPanel.setBackground(new Color(102, 51, 0));
        this.buttonPanel.setBackground(new Color(102, 51, 0));
        }
        
         public void setColorIndigo()
        {
        this.mainPanel.setBackground(new Color(75, 0, 130));
        this.buttonPanel.setBackground(new Color(75, 0, 130));
        }
        
         public void setColorViolet()
        {
        this.mainPanel.setBackground(new Color(102, 0, 102));
        this.buttonPanel.setBackground(new Color(102, 0, 102));
        }
        
        public void someVisualisation()
        {
             
            this.textArea.append("Loading... please wait.");
            
               for(int y=0; y<4; y++)
               {
                    pause(10);
                    setColorRed();
                    pause(60);
                    setColorOrange();
                    pause(90);
                    setColorYellow();
                    pause(80);
                    setColorGreen();
                    pause(60);
                    setColorBrown();
                    pause(60);
                    setColorIndigo();
                    pause(20);
                    setColorViolet();
                    pause(10);
                    setColorRed();
                    pause(60);
                    setColorOrange();
                    pause(90);
                    setColorYellow();
                    pause(80);
                    setColorGreen();
                    pause(60);
                    setColorBrown();
                    pause(60);
                    setColorIndigo();
                    pause(20);
                    setColorViolet();
                }
                
        this.textArea.setText(" ");
        //Set our main colors back after the loop   
        this.mainPanel.setBackground(this.BACKGROUND_COLOR);
        this.buttonPanel.setBackground(this.BACKGROUND_COLOR);
        
        }
        
    


        /* The "createImageIcon" method finds the specified file and returns an ImageIcon for that file, or null if that file couldn't be found. Here is a typicalimplementation: */
        protected ImageIcon createImageIcon(String path,String description) 
        {
            java.net.URL imgURL = getClass().getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL, description);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        
        }
}
 