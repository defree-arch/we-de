import java.util.*;

public class targetlist {

    // field of class
    private ArrayList<Task> targets;

    // constructor
    public targetlist() {
        targets = new ArrayList<>();
    }

    // getter 
    public ArrayList<Task> getTargets() {
        return targets;
    }

    // setter
    public void setTargets(ArrayList<Task> targets) {
        this.targets = targets;
    } 

    // screen
    public void screen() {
        System.out.println("""
            1 - Добавить задачу;
            2 - Показать задачи;
            3 - Удалить задачу;
            4 - Выход.
            Выберите действие:
                """);
    }

    // mark task
    public void markTask(Scanner scan) {
        System.out.println("Какую задачу пометить (номер): ");
        int number = scan.nextInt() - 1;

        if (number >= targets.size() || number < 0)
            throw new IllegalArgumentException("Нет такой задачи!");
        targets.get(number).markDone();
    }
    // add deal
    public void addDeal(Task task) {
        targets.add(task);
    }

    // delete deal
    public void deleteDeal(int index) {
        if (index < 1 || index > targets.size()) {
            throw new IllegalArgumentException("Нет такой задачи!");
        }
        targets.remove(index - 1);
    }

    // print deals
    public void printDeals() {
        //throws are deleted
        targets.sort(Comparator.comparing(Task::getPriority));
        for (int i = 0; i < targets.size(); i++) {
            System.out.println(i + 1 + ". " + targets.get(i));
        }
        System.out.println();
        System.out.println("""
        \n1 - Меню;
        2 - Пометить задачу как решённую.
        Выберите действие:
        """);
    }

    // the number of deals
    public int sizeDeals() {
        return targets.size();
    }

    // exit
    public void exit() {
        System.out.println("Выход...");
        System.exit(0);
    }

    // ask priopity
    private Priority priorityIs(Scanner scan) {
        try {
            System.out.println("Введите приоритет задачи (от 1 до 3, где 1 - низкий, 3 - высокий): ");
            int level = scan.nextInt();
            if (level == 1) return Priority.LOW;
            else if (level == 2) return Priority.MEDIUM;
            else return Priority.HIGH;
        } catch (InputMismatchException e) {
            System.out.println("Указано неверное значение приоритета, по-умолчанию приоритет - MEDIUM.");
            return Priority.MEDIUM;
        }
    }  



    public static void main(String[] args) {
        targetlist deals = new targetlist();
        Scanner scan = new Scanner(System.in, "UTF-8");
        //action = scan.nextInt();
        //scan.nextLine();
        rwtargets storage = new rwtargets("targets.txt");
        deals.setTargets(storage.readTasks());
        int action = 0;
        while (action != 4) {
            deals.screen();

            try {
                action = scan.nextInt();
                scan.nextLine();

                //if (action < 0) {
                //    throw new IllegalArgumentException("Нет такого действия!");
                //}
                switch (action) {
                    case 1:
                        System.out.println("Напишите задачу, которую хотите добавить: ");

                        String name = scan.nextLine();
                        Priority priority = deals.priorityIs(scan);
                        Task deal = new Task(name, priority);

                        deals.addDeal(deal);
                        break;
                    case 2:
                        if (deals.sizeDeals() > 0) {
                            System.out.println("Список задач: ");
                            deals.printDeals();
                            while (scan.nextInt() != 1) {
                                deals.markTask(scan);
                                deals.printDeals();
                            }
                        }
                        else {
                            System.out.println("Задач нет.");
                        }
                        break;
                    case 3:
                        System.out.println("Выберите какую задачу удалить (номер)");
                        int index_deal = scan.nextInt();
                        deals.deleteDeal(index_deal);
                        break;
                    default:
                        break;

                }
            } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не число.");
            scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } 
        }
        storage.saveTasks(deals.getTargets());
        scan.close();
        deals.exit();
    }
}
