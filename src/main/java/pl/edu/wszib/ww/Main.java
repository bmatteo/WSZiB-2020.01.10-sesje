package pl.edu.wszib.ww;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        //new Thread(new Watek(1)).start();
        //new Thread(new Watek(2)).start();
        //new Thread(new Watek(3)).start();
        //new Thread(new Watek(4)).start();

        new Watek2().start();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        executor.execute(new Watek(1));

    }
}
