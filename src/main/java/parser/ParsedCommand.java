package parser;

import java.util.ArrayList;
import java.util.List;

public class ParsedCommand {
    private String action;
    private List<String> args = new ArrayList<>();

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "ParsedCommand{" +
                "action='" + action + '\'' +
                ", args=" + args +
                '}';
    }
}
