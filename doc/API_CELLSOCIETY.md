# Slogo API Design Exercise
## API Analysis
### Team 4:
#### Simulation:
* RockPaperScissorsCell:
    * updateColor():should not be part of the API, but had to be public in order to oveerride the updateColor() in cell.java
    * update() and react(): should be part of External API as they are called in Main.java
    * getDataFields(): should be public because it is used by XML parser to figure out what data needs to be present within the XML to sucessfulyy constuct a RockPaperScissorsCell Object
    * getSimulationType(): External API, because it is used by XML parser to check that the XML Simulation type matches that of the Cell being constructed

* Simplified API:
    * External:
        * update(),react(), getDataFields()
    * Internal:
        * updateColor(), setShape(), getRow(),getCol(),getState(), getNeighbours()

