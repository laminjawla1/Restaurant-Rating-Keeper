import ui.Advance;
import ui.Basic;

public class App {
    public static void main(String[] args) {
        if (args.length > 0)
            if (args[0].equalsIgnoreCase("advance"))
                Advance.run();
        Basic.run();
    }
}