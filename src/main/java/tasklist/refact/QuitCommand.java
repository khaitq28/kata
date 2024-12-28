package tasklist.refact;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class QuitCommand extends Command {
    @Override
    public void execute(ProjectData data) {
        out.println("do nothing");
    }

}
