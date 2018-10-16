![](https://i.imgur.com/24hV1Zq.jpg)
Slogo Design Doc
===



# Introduction
This project implements a SLogo interpreter, which is a simplified version of the Logo programming language. Our implementation will be most flexible in adding and interpreting new commands. The Backend.Command class will be open and extensible, while the rest of the program should be mostly closed. 

When a user enters a command into the UI, the text is passed to the Backend.TextParser, which instantiates the appropriate Backend.Command objects which execute the command. Output is either in the form of a text string passed back to the UI or movement of the Turtle, which is then displayed by the UI. 

# Design Overview

## API
### Front-End
* TurtleView
    * Responsibilities:
        * Track command history
        * Track turtle position history
        * Display turtle
        * Interpolate lines from turtle positions
    * Interactions
        * Gets coordinates and penup/down statefrom Turtle
    * Internal Methods
        * protected void drawTurtle()
        * protected void drawLines()
* CommandInputView
    * Responsibilities:
        * Take text input for commands
        * Display command history and errors
    * Interactions
        * Passes input to Backend.TextParser
        * Recieves output/errors from Backend.TextParser
    

### Back-End

* Turtle
    * Responsibilities
        * Moving
        * Track pen state
        * Track orientation
        * Track location
        * Track visibility
    * Interactions
        * External methods are called by Commands
    * External Methods
        * public void setOrientation(int deg)
        * public void move(int dist)
        * public void penUp()
        * public void penDown()


* variableTracker
    * Responsibilities:
        * Track variables
    * Interactions
        * Methods are called by Backend.TextParser
    * External Methods
        * public Object addVar(String key, Object Value)
        * public Object setVar(String key, Object Value)
        * public Object getVar(String key)
        * public Object deleteVar(String key)
        * public Object[] getAllVars()
        * public void deleteAllVars()
* textParser
    * Responsibilities:
        * Hold map of strings to method calls
        * Check for validity of commands
        * Check for validity of parameters
            * Pass errors to View
        * Call methods in Turtle
        * Calls the correct Backend.Command class
    * External Methods
        * public String parse(String[] arguments)
            * returns the String representation of the parsed command

* Backend.Command
     * Responsibilities:
        * Call the correct methods
    * Internal Methods
        * public Object execute(List<String> params)
    * public int getParamNumber()



# User Interface
The user will interact with the program through a GUI. The overall appearance will consist of three components: a text input field, a grid view in which the turtle moves and a column that displays all the commands that users have entered.
The only component that users will be able to interact with is the text input field where they enter text commands. 
Error messages will be displayed below the text input field if users enter invalid commands.
Here is an image for the layout of our GUI:
![](https://i.imgur.com/ldZyNRl.jpg)

# API Details
**UML Overview**
![UML API Overview](https://i.imgur.com/LNLSukK.jpg)
**API Flow**
![Program Flow](https://i.imgur.com/zhpoebP.jpg)
* **Controller.java**
    * Main Class that contains the logic for loading the stage and scene.
* **CommandInputView.java**
    * CommandInputView is responsible for passing the commands users enter to Backend.TextParser as a string. Then, Backend.TextParser will return either an output or a error message due to invalid commands. It will display command history. 
* **TurtleView.java**
    * View responsible for moving turtle on the screen and drawing lines after the turtle moves. Contains the turtle ImageView and variables storing the turtle's location and orientation on the screen. An instance of TurtleView is stored in Turtle.java, and each time a change to Turtle occurs, the update() method with Turtle's new location and orientation is called on that isntance of TurtleView. This allows for multiple turtles to be on the screen.
* **Backend.TextParser.java(maybe Backend.CommandManager.java as an alternate name)**
    * Responsible for parsing the text input as commands. Contains a map of Regex keys matched to commands. Tries to parse the user input, checking if each space separated expression is either a command or a valid parameter. If it's a valid command, it is pushed into a command stack and if it is a parameter, it is pushed to a parameter stack. If something is neither, then parser throws an error. Otherwirse, once the input is entirely parsed, the parser enters a while loop until the stack is empty and pops one command at a time. It then checks the number of parameters the command requires and pops that many parameters from the parameters stack. Then it calls command.execute() with those parameters, and adds the return value of that command to a parameter stack. This allows the user to string commands as long as the return type is consistent.
* **Backend.Command.java**
    * Interface that will be implemented by all commands
    * Required methods: 
        * int getParamNumber(): returns number of required parameters
        * Object execute(List <String> params): executes the command; throws error if parameters cannot be pased to integer or double
* **VariableTracker.java**
    * Stores and manages the user defined variables. Called by Backend.TextParser to set and get variable values
* **Turtle.java**
    * Keeps track of turtle coordinates and penup/down, as well as visibility
    * Calls its instance of TurtleView to update() the turtle on the screen

```java

package Model;
import java.util.*;
/**
 * 
 */
public interface VariableTracker {
    /**
     * @param  key
     * @param  value
     */
    public Object addVar( String key,  Object value);
    /**
     * @param  key
     */
    public Object getVar( String key);
    /**
     * 
     */
    public Object[] getAllVars();
    /**
     * 
     */
    public void clearAllVars();
    /**
     * @param  key
     */
    public void deleteVar( String key);
    /**
     * @param key
     * @param value
     */
    public Object setVar(String key,  Object value);
}
```
```java
package Model;

import java.util.*;

/**
 * 
 */
public interface Backend.Command {

    /**
     * @param methodKey
     */
    public Object execute(List<String>params);
    
    /**
     * @return numberOfParameters
     */
    public int getParamNumber();

}

```

```java 
package Model;

import java.util.*;

/**
 * 
 */
public interface Backend.TextParser {


    /**
     * @param  str
     */
    public void parse(String str);

    /**
     * 
     */
    public List<String> getAvailibleCommands();

}
```
```java
package Model;

import java.util.*;

/**
 * 
 */
public interface Turtle {

    public void move( int x,  int y);

    /**
     * @param  x
     * @param  y
     */
    public void turn(int x,  int y);

}

```

```java 
package Model;


public interface TurtleView {

 
   /**
   *@param xcor: x coordinate
   *@param ycor: y coordinate
   *@param orientation: orientation  in degrees
   */
    public void updateTurtle(int xCor, int yCor, int Orientation);

}

```

# API Example Code
* *The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.*
    * ```myTextParser.parse(myTextView.getText())```
        * ```commandMap.get(commandStack.pop()).execute(paramsStack.pop)```
            * ```myTurtle.move(50)```
                * ```myTurtleView.update(myXPos,myYPos,myOrientation)```
* Backend.Command Logic
    * *User types 'pu' in the command window*
        * pu.execute is called by Backend.TextParser
        * ```myTurtle.penUp;```
        * ```return null;```
    * *User types 'fd sum 1 2' in the command window*
        * ```sum.execute(int exp1, int exp2)``` is called by Backend.TextParser with parameters popped of the parameter stack
            * ```return exp1 +exp2```
        * fd.execute(int dist) is called by the Backend.TextParser 
            * ```myTurtle.move(dist)```
            * ```return null```
* Parser Logic
    * fd sum 10 20
        ```java
        String[]inputs=String.split(input);
        for(String s:inputs){
        if(commandMap.containsKey(s))
        commandStack.push(s);
        }
        else if commandStack.empty{throw new IllegalArgumentError("Invalid input")}
        else paramStack.push(s);
        
        while(!commandStack.empty()){
            String command = stack.pop;
            List<String>paramList=new ArrayList();
            for(int i=0i<commandMap.get(command).getParamNumber();i+=1){
            paramList.add(paramStack.pop());
            }
            Object obj=commandMap.get(command).execute(paramList)
            if(obj!=null)paramStack.push(obj);
        }
        
        ```
         fd max 10 20
        ```java
        String[]inputs=String.split(input);
        for(String s:inputs){
        if(commandMap.containsKey(s))
        commandStack.push(s);
        }
        else if commandStack.empty{throw new IllegalArgumentError("Invalid input")}
        else paramStack.push(s);
        
        while(!commandStack.empty()){
            String command = stack.pop;
            List<String>paramList=new ArrayList();
            for(int i=0i<commandMap.get(command).getParamNumber();i+=1){
            paramList.add(paramStack.pop());
            }
            Object obj=commandMap.get(command).execute(paramList)
            if(obj!=null)paramStack.push(obj);
        }
        
        ```
* VariableTracker Logic
    * *User types SET distance 20*
        * VariableTracker object within Backend.TextParser adds string "distance" and Integer 20 to its own map of stored variables of type Map<String, Object>
        ```java
            tracker.put("distance", 20);
        ```
        
* Turtle Logic
    * *User types fd 50*
        * Updates x and y based on current angle, distance, and current x and y by using simple trigonometry
        ```java
            move(dis) {
                x += Math.floor(dist * Math.cosine(Math.toRadians(orientation)));
                y += Math.floor(dist * Math.cosine(Math.toRadians(orientation)));
            }
        ```


* UI use cases:
    * When users enter a command in the text input field and hit enter: 
    * Inside the CommandInputHandler:
        ```java
            String result = textParser.parse(command); // parse the string we get from the text input field            
        ```
    
    * When users enter a turtle-moving command:
        ```java
            // inside turtle class there is an instance of TurtleView called turtleView
            turtleView.update(int x, int y)
        ```

# Design Considerations
* Should commands validate their own parameters or should Backend.TextParser do it?
    * Giving parameter validation responsibility to Backend.TextParser would keep all validation centralized in one class
    * Letting each command validate its own parameters means that it will be more modular; adding new commands will not require changing parameter validation code in Backend.TextParser
* Should TurtleView call a methods in Turtle to update, or should Turtle call methods in TurtleView to update?
    * Turtle calling TurtleView is more consistent with the MVC design pattern
    * TurtleView calling Turtle means that Turtle will not have to have access to TurtleView, making it more encapsulated. 
* How will multiple commands in one line and logic structures such as loops and conditionals be implemented?
    * Commands and parameters will be stored on a stack and pushed/popped as required. 

# Team Responsibility

* Michael
    * Backend.TextParser input parsing logic
* Christopher
    * Backend.Command interface and command logic
* Max
    * Turtle.java and VariableTracker.java
* Xi
    * UI
