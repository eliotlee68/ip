package aaron.command;

import aaron.exception.AaronBotException;
import aaron.parser.CommandDetailParser;
import aaron.task.TaskList;
import aaron.ui.UI;

public abstract class Command {
    public final String commandDetails;
    public final CommandType commandType;

    public Command(String userInput, CommandType commandType) throws AaronBotException {
        this.commandType = commandType;
        commandDetails = CommandDetailParser.getCommandDetails(userInput);
    }

    public abstract void run(TaskList taskList, UI ui);

    public abstract boolean returnIsBye();

}
