package tasklist.refact;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class HelpCommand extends Command {

    @Override
    public void execute(ProjectData data) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
