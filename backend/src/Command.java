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
}
