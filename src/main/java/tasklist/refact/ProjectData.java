package tasklist.refact;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.*;

public class ProjectData {
    @Getter
    private final Map<String, List<Task>> data = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;
    private Long lastId = 0L;

    public ProjectData(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private long nextId() {
        return ++lastId;
    }


    public void addTask(String project, String taskDesc) {
        List<Task> projectTasks = data.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), taskDesc, false));
    }

    public void addProject(String project) {
        this.data.put(project, new ArrayList<>());
    }


    private void setStatus(String taskId, boolean status) {
        for(Task task: data.values().stream().flatMap(List::stream).toList()) {
            if (Objects.equals(task.getId(), Long.valueOf(taskId))) {
                task.setDone(status);
                return;
            }
        }
        out.printf("Could not find a task with an ID of %d.", taskId);
        out.println();
    }

    public void checkTask(String taskId) {
        setStatus(taskId,true);
    }

    public void uncheckTask(String taskId) {
        setStatus(taskId,false);
    }

}
