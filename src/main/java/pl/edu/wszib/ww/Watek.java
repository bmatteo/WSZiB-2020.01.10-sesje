package pl.edu.wszib.ww;

public class Watek implements Runnable {

    int number;

    public Watek(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            System.out.println("Runnable number: " + this.number + " element: " + i);
        }
    }
}
