package deposit;

import java.util.Random;

public class Budget {
    private Random random = new Random();

    private int counter = 0;


    static int familyBudget = 50;

    public Budget() {

    }

    public synchronized Budget getDeposit() throws InterruptedException {
        while (counter <= 5) {
            int childPurchases = random.nextInt(6) + 30;

            counter++;
            if (familyBudget < 100) {


                System.out.println("Very small deposit");
                wait();
            } else {
                familyBudget -= childPurchases;
                System.out.printf(" -%d$ Бюджет составляет %d$ после покупки для первого ребенка %n", childPurchases, familyBudget);


                notifyAll();
            }
        }
        return this;
    }

    public synchronized void putDeposit() {

        while (counter < 2) {

            counter++;
            familyBudget += 4_000;
            System.out.println("родитель " + Thread.currentThread().getName() + " пополнил счет +  " + familyBudget);
        }
        counter = 0;
        notifyAll();

    }

}
