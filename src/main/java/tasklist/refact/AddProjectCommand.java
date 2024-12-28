package tasklist.refact;

public class AddProjectCommand extends Command {

    private String project;
    public AddProjectCommand(String project) {
        this.project = project;
    }

    @Override
    public void execute(ProjectData data) {
        data.addProject(project);
    }
}
