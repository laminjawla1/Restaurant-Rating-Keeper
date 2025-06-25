package parser;

import java.util.List;

@FunctionalInterface
public interface CommandHandler {
    void handle(List<String> args) throws Exception;
}
