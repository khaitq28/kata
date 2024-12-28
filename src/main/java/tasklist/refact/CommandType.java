package tasklist.refact;

public enum CommandType {

    ADD,
    CHECK,
    SHOW,
    UNCHECK,
    HELP,
    QUIT;

    public static CommandType fromString(String command) {
        return switch (command.toLowerCase()) {
            case "add" -> ADD;
            case "check" -> CHECK;
            case "show" -> SHOW;
            case "uncheck" -> UNCHECK;
            case "help" -> HELP;
            case "quit" -> QUIT;
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }
}
