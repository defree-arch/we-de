import java.util.*;

public class targetlist {

    // field of class
    private ArrayList<String> targets;

    // constructor
    public targetlist() {
        targets = new ArrayList<>();
    }

    // getter 
    public ArrayList<String> getTargets() {
        return targets;
    }

    // setter
    public void setTargets(ArrayList<String> targets) {
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

    // add deal
    public void addDeal(String s) {
        targets.add(s);
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
        for (int i = 0; i < targets.size(); i++) {
            System.out.println(i + 1 + ". " + targets.get(i));
        }
    }

    //the number of deals
    public int sizeDeals() {
        return targets.size();
    }

    // exit
    public void exit() {
        System.out.println("Выход...");
        System.exit(0);
    }

    public static void main(String[] args) {
        targetlist deals = new targetlist();
        Scanner scan = new Scanner(System.in, "UTF-8");
        //action = scan.nextInt();
        //scan.nextLine();
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
                        String deal = scan.nextLine();
                        deals.addDeal(deal);
                        break;
                    case 2:
                        if (deals.sizeDeals() > 0) {
                            System.out.println("Список задач: ");
                            deals.printDeals();
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
        rwtargets saving = new rwtargets("targets.txt");

        scan.close();
        deals.exit();
        
    }
}
