package produsserConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Runner {
    public static void main(String[] args) {
        Threads t1 = new Threads("First");
        Threads t2 = new Threads("Sec");
        //  t1.run();
        // t2.run();
        try {
            ExecutorService execute = Executors.newFixedThreadPool(2);
            execute.submit(t1);
            execute.submit(t2);
        } catch (IllegalArgumentException e) {

        }

    }
}
