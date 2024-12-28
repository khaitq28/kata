package tasklist.refact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private final ProjectData projectData;
    private final BufferedReader in;
    private final PrintWriter out;
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        projectData  = new ProjectData(in, out);
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        Command command = CommandFactory.createCommand(commandLine);
        command.execute(projectData);
    }

//    private void show() {
//        for (String project : projects.keySet()) {
//            out.println(project);
//            for (Task task : projects.get(project)) {
//                out.printf("    [%c] %d: %s%n", (task.getDone() != null && task.getDone()  ? 'x' : ' '), task.getId(), task.getDescription());
//            }
//            out.println();
//        }
//    }
//
//    private void add(String commandLineArgument) {
//        String[] subcommandRest = commandLineArgument.split(" ", 2);
//        String subcommand = subcommandRest[0];
//        if (subcommand.equals("project")) {
//            addProject(subcommandRest[1]);
//        } else if (subcommand.equals("task")) {
//            String[] projectTask = subcommandRest[1].split(" ", 2);
//            addTask(projectTask[0], projectTask[1]);
//        }
//    }

//    private void addProject(String name) {
//        projects.put(name, new ArrayList<>());
//    }

//    private void addTask(String project, String description) {
//        List<Task> projectTasks = projects.get(project);
//        if (projectTasks == null) {
//            out.printf("Could not find a project with the name \"%s\".", project);
//            out.println();
//            return;
//        }
//        projectTasks.add(new Task(nextId(), description, false));
//    }

//    private void check(String idString) {
//        updateTaskStatus(idString, true);
//    }
//
//    private void uncheck(String idString) {
//        updateTaskStatus(idString, false);
//    }

//    private void updateTaskStatus(String idString, boolean done) {
//        int id = Integer.parseInt(idString);
//        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
//            for (Task task : project.getValue()) {
//                if (task.getId() == id) {
//                    task.setDone(done);
//                    return;
//                }
//            }
//        }
//        out.printf("Could not find a task with an ID of %d.", id);
//        out.println();
//    }

//    private void help() {
//        out.println("Commands:");
//        out.println("  show");
//        out.println("  add project <project name>");
//        out.println("  add task <project name> <task description>");
//        out.println("  check <task ID>");
//        out.println("  uncheck <task ID>");
//        out.println();
//    }

//    private void error(String command) {
//        out.printf("I don't know what the command \"%s\" is.", command);
//        out.println();
//    }
//
//    private long nextId() {
//        return ++lastId;
//    }
}