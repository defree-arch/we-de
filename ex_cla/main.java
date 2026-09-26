package ex_cla;
import java.util.InputMismatchException;
import java.util.Scanner;

import ex_cla.targetlist;

public class  main() {
    targetlist deals = new targetlist(null);
    targetlist.screen();
    Scanner scan = new Scanner(System.in);
    int action = scan.nextInt();
    while (action != 4) {
        try {
            if (action < 1) {
                throw new IllegalArgumentException("Нет такого действия!");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: Введено не число.");
            throw new IllegalArgumentException("Некорректный ввод данных.");
        }
        switch (action) {
            case 1:
                System.out.println("Напишите задачу: ");
                String deal = scan.next();
                targetlist.addDeal(deal);
                break;
            case 2:
                System.out.println("Список задач: ");
                targetlist.printDeals();
                break;
            case 3:
                System.out.println("Какую задачу удалить? (введите номер)");
                targetlist.deleteDeal();
                break;
            default:
                break;
        }
        action = scan.nextInt();
    }

}

