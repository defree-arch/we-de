package ex_cla;
import java.util.*;
public class targetlist {
    
    //field of class
    private ArrayList<String> targets;
    
    //constructor
    public targetlist (ArrayList<String> targets) {
        this.targets = targets;
    }
    
    //start screen
    public void startScreen () {
        System.out.println("\n1 - Добавить задачу; \n2 - Показать задачи; \n3 - Удалить задачу; 4 - Выйти. \nВыберите действие:  ");
    }

}
