package pl.edu.wszib.ww;

public class Watek2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
    }
}
