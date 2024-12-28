package tasklist.refact;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ShowCommand extends Command {

    @Override
    public void execute(ProjectData projectData) {

        out.println("show here");
        for (String project : projectData.getData().keySet()) {
            out.println(project);
            for (Task task : projectData.getData().get(project)) {
                out.printf("    [%c] %d: %s%n", (task.getDone() != null && task.getDone()  ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
