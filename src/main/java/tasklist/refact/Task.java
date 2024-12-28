package tasklist.refact;


import lombok.Data;

@Data
public final class Task {
    private final Long id;
    private final String description;
    private Boolean done;
    public Task(Long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public String getTaskInfo() {
//        out.printf("    [%c] %d: %s%n", (task.getDone() != null && task.getDone()  ? 'x' : ' '), task.getId(), task.getDescription());
        return String.format("%d %s %s", id, done ? "[x]" : "[ ]", description);
    }

}