package parser;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    public static ParsedCommand parseCommand(String command) {
        ParsedCommand parsedCommand = new ParsedCommand();
        List<String> tokens = tokenize(command);

        parsedCommand.setAction(tokens.getFirst());

        if (tokens.size() > 1) {
            parsedCommand.setArgs(tokens.subList(1, tokens.size()));
        }

        return parsedCommand;
    }

    private static List<String> tokenize(String command) {
        return Arrays.stream(command.split(" ")).toList();
    }
}
