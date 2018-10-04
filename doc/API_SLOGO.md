# SLogo Architecture Design

1. What is the parsing and who receives it?
    * The front-end will split the input string into an array of string based upon the location of spaces and pass it to back-end.
    * The back-end check's the validity of the given array of strings. If some commands/parrameters are invalid, throws Exception
    * Exception is shown on front-end either via alert or some other way
2. When does parsing need to take place and what does it need to start properly?
    * User needs to press enter
    * All text inputs are valid inputs on front-end side
3. When are errors detected and how are they reported?


## Front-End
* TurtleRenderer
    * Responsibilities:
        * Track command history
        * Track turtle position history
        * Display turtle
        * Interpolate lines from turtle positions
    * Internal Methods
        * protected void drawTurtle()
        * protected void drawLines()
* CommandInputHandler
    * Responsibilities:
        * Take text input for commands
        * Display command history and errors

## Back-End

* Turtle
    * Responsibilities
        * Moving
        * Track pen state
        * Track orientation
        * Track location
        * Track visibility
    * External Methods
        * public void setOrientation(int deg)
        * public void move(int dist)


* variableTracker
    * Responsibilities:
        * Track variables
    * External Methods
        * public void newVariable(String varName, double val)
        * public double getValue(String varName)
* textParser
    * Responsibilities:
        * Check for validity of commands
        * Check for validity of parameters
            * Pass errors to View
        * Call methods in Turtle
        * Calls the correct Command class
    * External Methods
        * public String parse(String[] arguments)
            * returns the String representation of the parsed command

* Command
     * Responsibilities:
        * Hold map of strings to method calls
        * Call the correct methods
    * External Methods
        * public void execute(int[] params)

# Use Cases
* The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.
    * 'fd' and '50' are recieved by CommandInputHandler and split up and passed to textParser as a String[]
    * textParser looks up and creates a new Command object and passes '50' as an int to it. Also passes "fd 50" to CommandInputHandler
    * CommandInputHandler displays "fd 50" in the command history window
    * fd command object calls Turtle.move(50)
    * TurtleRenderer updates turtle sprite location and draws line if pen is down
* The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.
    * '50' and 'fd' are recieved by CommandInputHandler and split up and passed to textParser as a String[] 
    * textParser detects an error and passes "Error: Invalid Command" to CommandInputHandler
    * CommandInputHandler displays "Error: Invalid Command"