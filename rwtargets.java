import java.io.*;
import java.util.ArrayList;

public class rwtargets {

    // field with name of file
    private String file;

    // constructor
    public rwtargets(String file) {
        this.file = file;
    }

    // save to file
    public void saveTasks(ArrayList<String> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read file
    public void readTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}