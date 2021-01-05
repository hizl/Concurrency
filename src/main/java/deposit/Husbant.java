package deposit;

public class Husbant extends Thread {
    Budget budget;

    public Husbant(Budget budget) {
        this.budget = budget;
    }

    @Override
    public void run() {
        setName("DADDY ");
        for (int i = 0; i < 3; i++) {
            budget.putDeposit();
        }
    }
}
