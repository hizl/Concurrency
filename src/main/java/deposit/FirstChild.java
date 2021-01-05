package deposit;

import java.util.Random;

public class FirstChild extends Thread {
    public static int cycles = 0;
    Budget budget;


    public FirstChild(Budget budget) {
        this.budget = budget;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cycles++;
            try {
                budget.getDeposit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
