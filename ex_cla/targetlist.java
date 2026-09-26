package ex_cla;
import java.util.*;
;
public class targetlist {
    
    //field of class
    private static ArrayList<String> targets;
    
    //constructor
    public targetlist (ArrayList<String> targets) {
        targets = new ArrayList<>();
    }
    
    // screen
    public static void screen () {
        System.out.println("""
            1 - Добавить задачу;
            2 - Показать задачи;
            3 - Удалить задачу;
            4 - Выход.
            Выберите действие:  
        """);
    }

    //add deal
    public static void addDeal (String s) {
        targets.add(s);
    }

    //delete deal
    public static void deleteDeal () {
        Scanner scan = new Scanner(System.in);
        try {
            int index = scan.nextInt();
            
            if (index < 1) {
                throw new IllegalArgumentException("Нет такой задачи!");
            }
            targets.remove(index);
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: Введено не число.");
            throw new IllegalArgumentException("Некорректный ввод данных.");
        }
        finally {
            scan.close();
        }
    }

    //print deals
    public static void printDeals() {
        for (int i = 0; i < targets.size(); i++) {
            System.out.println(i + 1 + ". " + targets.get(i));
        }
    }

    //exit
    public void exit() {
        System.out.println("Выход...");
        exit();
    }
}
