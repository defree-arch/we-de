package ex_cla;
import java.util.*;
;
public class targetlist {
    
    //field of class
    private ArrayList<String> targets;
    
    //constructor
    public targetlist (ArrayList<String> targets) {
        this.targets = targets;
    }
    
    //start screen
    public void startScreen () {
        System.out.println("\n1 - ˜˜˜˜˜˜˜˜ ˜˜˜˜˜˜; \n2 - ˜˜˜˜˜˜˜˜ ˜˜˜˜˜˜; \n3 - ˜˜˜˜˜˜˜ ˜˜˜˜˜˜; 4 - ˜˜˜˜˜. \n˜˜˜˜˜˜˜˜ ˜˜˜˜˜˜˜˜:  ");
    }

    //add deal
    public void addDeal (String s) {
        targets.add(s);
    }

    //delete deal
    public void deleteDeal () {
        Scanner scan = new Scanner(System.in);
        try {
            int index = scan.nextInt();
            
            if (index < 1) {
                throw new IllegalArgumentException("Íåò òàêîé çàäà÷è!");
            }
            this.targets.remove(index);
        }
        catch (InputMismatchException e) {
            System.out.println("Îøèáêà: Ââåäåíî íå ÷èñëî.");
            throw new IllegalArgumentException("Íåêîððåêòíûé ââîä äàííûõ.");
        }
        finally {
            scan.close();
        }
    }

    //print deals
    public void printDeals() {
        for (int i = 0; i < this.targets.size(); i++) {
            System.out.println(i + 1 + ". " + this.targets.get(i));
        }
    }

    //exit
    public void exit() {
        System.out.println("Âûõîä...");
        exit();
    }
}
