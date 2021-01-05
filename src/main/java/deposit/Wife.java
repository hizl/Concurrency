package deposit;

public class Wife extends Thread {
    Budget budget;



    public Wife(Budget budget) {
        this.budget = budget;
    }

    @Override
    public void run() {
        setName("MOM ");
        for (int i = 0; i < 2; i++) {
            budget.putDeposit();
        }
    }
}
