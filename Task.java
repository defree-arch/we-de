
public class Task {

    // fields
    private String name;
    private Priority priority;
    private Boolean done;

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

    public Boolean isDone() {
        return done;
    }

    public void markDone() {
        done = true;
    } 
}
