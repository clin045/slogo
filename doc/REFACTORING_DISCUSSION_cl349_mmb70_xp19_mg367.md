Refactoring
===

Duplication Refactoring
---
* Refactored duplicated methods inside ControlPanelView.java
* Made custom errors to avoid throwing IllegalArgumenExceptions with the same text over and over again
    * Created a CustomError.java which extends IllegalArgumentExccfeption and  some of its subclasses


Checklist Refactoring     
---
* Refactored CommandManager.execute and Command.parseParameters to use fewer nested try-catches




General Refactoring 
---
* Refactored hard-coded variables into public static final variables
* Moved getCommand into CommandManager