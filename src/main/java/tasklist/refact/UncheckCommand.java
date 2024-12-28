package tasklist.refact;

public class UncheckCommand extends Command {
    public UncheckCommand(String taskId) {
        this.taskId = taskId;
    }
    private final String taskId;
    @Override
    public void execute(ProjectData projectData) {
        projectData.uncheckTask(taskId);
    }
}
