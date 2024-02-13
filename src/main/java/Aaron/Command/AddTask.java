package aaron.command;

import aaron.exception.AaronBotException;
import aaron.exception.InvalidTaskTypeException;
import aaron.exception.TaskErrorException;
import aaron.exception.TaskNoNameException;
import aaron.parser.TaskDetailParser;
import aaron.task.TaskList;
import aaron.task.TaskType;
import aaron.ui.UI;

/**
 * class that represents a command to add a task to the tasklist
 */
public class AddTask extends Command {
    public AddTask(String userInput, CommandType commandType) throws AaronBotException {
        super(userInput, commandType);
    }

    @Override
    public void run(TaskList taskList, UI ui) {
        TaskType taskType;
        String taskDetails;
        try {
            taskPresenceCheck(commandDetails);
        } catch (TaskNoNameException e) {
            ui.errorMessage(e);
            return;
        }
        try {
            taskType = TaskDetailParser.getTaskType(commandDetails);
            taskDetails = TaskDetailParser.getTaskDetails(commandDetails);
        } catch (InvalidTaskTypeException e) {
            ui.errorMessage(e);
            return;
        }
        try {
            taskList.addToList(taskType, taskDetails);
            ui.taskAddedMessage(taskList);
        } catch (TaskErrorException e) {
            ui.errorMessage(e);
            return;
        }
    }

    @Override
    public boolean returnIsBye() {
        return false;
    }

    /**
     * Method to check if an add command is of the correct format
     * @param userInputString
     * @throws TaskNoNameException if the command is in incorrect format
     */
    private static void taskPresenceCheck(String userInputString) throws TaskNoNameException {
        if (userInputString.split("\\s+").length <= 1) {
            throw new TaskNoNameException(userInputString);
        }
    }
}
