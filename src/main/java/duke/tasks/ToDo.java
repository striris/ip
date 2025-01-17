package duke.tasks;

/**
 * Represents a ToDo Task
 */
public class ToDo extends Task {

    public ToDo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String saveTasks() {
        return "T " + super.saveTasks() + System.lineSeparator();
    }
}
