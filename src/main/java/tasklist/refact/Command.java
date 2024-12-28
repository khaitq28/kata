package tasklist.refact;

import lombok.Data;


@Data
public abstract class Command {

    protected CommandType type;
    public abstract void execute(ProjectData projectData);
}