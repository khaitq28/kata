package tasklist.refact;

public class CommandFactory {

    private CommandFactory() {
    }
    public static Command createCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        if (commandRest.length == 0) {
            throw new IllegalArgumentException("No command found");
        }
        String command = commandRest[0];
        String parameter = null;
        if (commandRest.length > 1) {
            parameter = commandRest[1];
        }
        return switch (command.toLowerCase()) {
            case "add" -> {
                String[] subcommandRest = parameter.split(" ", 2);
                String subcommand = subcommandRest[0];
                if (subcommand.equals("project")) {
                    yield new AddProjectCommand(subcommandRest[1]);
                } else if (subcommand.equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    yield new AddTaskCommand(projectTask[0], projectTask[1]);
                } else
                    throw new IllegalArgumentException("Unknown command: " + command);
            }
            case "check" -> new CheckCommand(parameter);
            case "show" -> new ShowCommand();
            case "uncheck" -> new UncheckCommand(parameter);
            case "help" -> new HelpCommand();
            case "quit" -> new QuitCommand();
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }

}
