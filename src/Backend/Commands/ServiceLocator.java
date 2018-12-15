package Backend.Commands;

import Backend.CommandManager;

public class ServiceLocator {
    static CommandManager myCommandManager;

    public static CommandManager getMyCommandManager(){
        return myCommandManager;
    }

    public static void provideCommandManager(CommandManager commandManager){
        myCommandManager = commandManager;
    }
}
