/**
 * class that represents a deadline type of task instantiated in an Aaronbot tasklist
 */
public class Deadline extends Task{
    private String deadline;
    public Deadline(String taskString, String deadline) {
        super(taskString);
        this.deadline = deadline;
    }

    public Deadline(String taskString, String deadline, boolean isDone) {
        super(taskString, isDone);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " | " + deadline;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Deadline)) {
            return false;
        }

        Deadline deadline = (Deadline) obj;
        return (super.equals(deadline) && this.deadline.equals(deadline.deadline));
    }

}
