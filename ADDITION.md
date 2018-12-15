Slogo Addition
===

* Estimation
    * 2 Hours
    * 2, 1 new Command file, modifications to TurtleManager to handle disabled but visible turtles

* Review
    * 4 Hours
    * Added ServiceLocator, edited Workspace and TurtleManager
        * In order for the backend to add new turtles, it has to have access to CommandManager, which necessitated a global access point which I provided using ServiceLocator
        * Workspace had to be edited to use ServiceLocator
        * TurtleManager was edited to provide the functionality of stamping and removing stamps
    * I definitely did not get it right on the first try
* Analysis
    * The project was much worse than I remembered. I didn't have to work with the frontend code at all until now, and I now see how convoluted and poorly designed it is. Parts of backend functionality were actually completely bypassed by the frontend
    * Using singletons or service locators would have made things much easier
    * It would have been impossible to do if I had not been familiar with the code, since it was quite difficult for me to do even with familiarity. 