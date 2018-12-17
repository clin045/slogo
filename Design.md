Design
===
## High Level Design Overview
- Create a flexible environment for running the Slogo language
- Allow for easy addition of new commands
- Allow for easy addition of different languages
- Allow flexibility in terms of return types, not just doubles
- Have a flexible UI
    - UI that allows multiple workspaces and turtles withing a workspace
## Adding new Features
- Adding new Commands:
    - Create a new Command class that extends Command.java or any of it's abstract subclasses. 
    - The constructor must accept a variable tracker and call super(tracker), and then setKey to the key that will correspond to this command inside Syntax & CommandDescriptions properties files.
    - Create a kewy value pair for the command in each language properties file and in each config properties files
- Adding new languages
    - Add a (language).properties file to the languages folder
- Adding New Turtle Image
    - Add the new turtle image to the `/res` folder 
    
## Design Justification
- Recursive vs stack scheduling of command
    - Handling commands as stacks of commands and parameters is more "elegant". However, there were issues handling cases such as sum sum 1 2 sum 1 2, so a recursive solution was necessary


## Assumptions
- When calling clearscreen, all turtles except one are removed. We made this choice because turtles will be overlapping and it becomes more difficult for users to click on the overlapping turtles if all of them are set to the origin
- When creating or setting a variable, do not prefix it with a colon.
- The info displayed in the turtle status panel reflects the state of the turtle that is clicked by users most recently