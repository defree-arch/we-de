public class Task {

    // fields
    private String name;
    private Priority priority;
    private boolean done;

    // constructor
    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        this.done = false;
    }

    // getters
    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    // mark task
    public void markDone() {
        done = true;
    } 

    // for output
    @Override 
    public String toString() {
        String mark = done ? "[x]" : "[ ]";
        return mark + " " + name + " (" + priority + ") ";
    }

    // for saving to file
    public String toFile() {
        return done + ";" + name + ";" + priority;
    }
    
    // setter for reading from file
    private void setDone(boolean done) {
        this.done = done;
    }

    // for getting from file "done;name;priority"
    public static Task parseTask(String s) {
        String[] parts = s.split(";");
        Priority priopity = Priority.valueOf(parts[2]);
        Boolean done = Boolean.parseBoolean(parts[0]);
        String name = parts[1];

        Task task = new Task(name, priopity);
        task.setDone(done);
        return task;

    }
    
}
