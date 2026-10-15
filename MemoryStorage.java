import java.util.ArrayList;

public class MemoryStorage implements TaskStorage{
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override 
    public void saveTasks(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<Task>(tasks);
    }

    @Override 
    public ArrayList<Task> readTasks() {
        return new ArrayList<Task>(tasks);
    }
}
