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
    public ArrayList<String> readTasks() {
        ArrayList<String> t = new ArrayList<>();
        File f = new File(file);
        if (!f.exists()) return t;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                t.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

}