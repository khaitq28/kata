package tasklist.refact;

public class CheckCommand extends Command {

    private String taskId;
    public CheckCommand(String taskId) {
        this.taskId = taskId;
    }
    @Override
    public void execute(ProjectData projectData) {
        projectData.checkTask(taskId);
    }
}
