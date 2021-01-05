package deposit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Budget familyBudget = new Budget();

        Thread moms = new Wife(familyBudget);
        Thread child = new FirstChild(familyBudget);
        Thread daddy = new Husbant(familyBudget);

        child.start();

        moms.start();
        daddy.start();


        moms.join();
        child.join();
        daddy.join();




        System.out.println("Баланс семьи на сегодня равен : "+ Budget.familyBudget + "$");


    }
}
