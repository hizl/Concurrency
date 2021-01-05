package produsserConsumer;

public class Runnables {

    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}

class Producer implements Runnable {
    Store store;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                store.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                store.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Store {
    private int counter = 0;

    public synchronized void get() throws InterruptedException {
        while (counter < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        counter--;
        System.out.println("-1 : the product was taken away");
        System.out.println(
                "\tquantity of goods in stock : " + counter);
        notify();
        Thread.sleep(500);
    }

    public synchronized void put() throws InterruptedException {
        while (counter >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        counter++;
        System.out.println("+1 : product added");
        System.out.println(
                "\tquantity of goods in stock  : " + counter);
        notify();
        Thread.sleep(1000);
    }
}


