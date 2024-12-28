package tasklist.refact;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class AddTaskCommand extends Command {

    private final String project;
    private final String taskDesc;
    public AddTaskCommand(String project, String taskDescription) {
        this.taskDesc = taskDescription;
        this.project = project;
    }

    @Override
    public void execute(ProjectData data) {
        data.addTask(project, taskDesc);
    }

}
