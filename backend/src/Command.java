public interface Command {
    /**
     *
     * @return number of parameters
     */
    public int getParamNumber();

    /**
     *
     * @return description of what the command does to the user
     */
    public String getDescription();

    /**
     * @apiNote parses the parameters needed for command to execute
     * @throws IllegalArgumentException
     */
    public void parseParameters(String[]params) throws IllegalArgumentException;
    public String execute();
    public boolean hasReturnValue();
}
