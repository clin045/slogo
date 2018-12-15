CompSci 308: SLogo Addition
===================

>how long do you think it will take you to complete this new feature?

I think completing this new feature will take no longer than 90 minutes.

>how many files will you need to add or update? Why?

I will have to add at least two new command files, CommandStamp and CommandClearStamps.

##### Review: after completing the feature:
>how long did it take you to complete this new feature?

It took about as long as I expected (not including a break I took while writing the code).

>how many files did you need to add or update? Why?

I needed to add two files (CommandClearStamps and CommandStamp), as expected, but I needed to edit a number of files too. On the backend, these included:

* CommandDescriptions.properties
* Commands.properties
* Syntax.properties
* English.properties (and in theory, the other language .properties files for a full implementation)

These files need to be edited for any additional commands added.

And to implement the command on the front end, I needed to edit:

* Controller
* TurtlePlayground

To add a new turtle command or display command, one must edit Controller to display the result on the frontend. I treated stamps as separate from turtles (though I could've done otherwise, I found this the most flexible approach) and this required adding a variable and methods to TurtlePlayground in order to track and change the stamps.

>did you get it completely right on the first try?

I got the stamp command right on the first try, but implementing clearstamps required some more thinking and testing. I think this had to do with the fact that I need to make changes to the front end as well.

##### Analysis: 

> what do you feel this exercise reveals about your project's design and documentation?

This exercise reveals the dependencies that remain in the project, especially from frontend to backend through controller. The circular dependency between Turtle and Controller complicates things considerably.

>was it as good (or bad) as you remembered?

Having learned more about design and practiced these skills in VOOOGASalad, the design appears worse than I remembered. We definitely should have and could have found a way to remove these dependencies.

>what could be improved?

The controller in front end could be replaced by a different design patterns such as the singleton or service locator. The TurtleView/TurtleViewManager could be better synchronized with Turtle and TurtleManager. Even if the design remained exactly the same, the frontend code requires significant refactoring and commenting, as methods are lengthy and hard to read.
>what would it have been like if you were not familiar with the code at all?

I feel like it would've been somewhat difficult if I was not familiar with the code at all. The frontend is not well documented and the design plan differs somewhat from our final design. And many classes are convoluted and require long chains of method calls.