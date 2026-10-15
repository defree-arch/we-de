import java.util.ArrayList;

public interface TaskStorage {
    void saveTasks(ArrayList<Task> tasks);
    ArrayList<Task> readTasks();
}
