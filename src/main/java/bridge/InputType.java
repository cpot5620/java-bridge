package bridge;

public enum InputType {
    NUMERIC("^[0-9]*$"),
    MOVE_UP_COMMAND("U"),
    MOVE_DOWN_COMMAND("D"),
    RESTART_COMMAND("R"),
    QUIT_COMMAND("Q");

    private final String command;

    InputType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static void validateNumber(String input) {
        if (!input.matches(NUMERIC.command))
            Error.printException(ErrorType.NUMERIC);
    }

    public static void validateMovingCommand(String input) {
        if (!input.equals(MOVE_UP_COMMAND.command)
                && !input.equals(MOVE_DOWN_COMMAND.command))
            Error.printException(ErrorType.MOVING);
    }

    public static void validateContinuousCommand(String input) {
        if (!input.equals(RESTART_COMMAND.command)
                && input.equals(QUIT_COMMAND.command))
            Error.printException(ErrorType.CONTINUING);
    }
}
