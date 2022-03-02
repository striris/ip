package duke.tasks;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String saveTasks() {
        return "D " + super.saveTasks() + " | " + this.by + System.lineSeparator();
    }
}

//this.description = description.substring(0, description.lastIndexOf("/") + 4);
