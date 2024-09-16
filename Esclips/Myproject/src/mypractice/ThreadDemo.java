package mypractice;

public class ThreadDemo {
    public static Object L1 = new Object();
    public static Object L2 = new Object();

    public static void main(String[] args) {
        ThreadDemo1 ob1 = new ThreadDemo1();
        ThreadDemo2 ob2 = new ThreadDemo2();
        ob1.start(); // Start the first thread
        ob2.start(); // Start the second thread
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (L1) {
                System.out.println("Thread 1: Holding Lock 1");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e1) {
                    System.out.println("e1");
                }
                System.out.println("Thread 1: Waiting for Lock 2...");
                synchronized (L2) {
                    System.out.println("Thread 1: Holding Lock 1 & 2");
                }
            }
        }
    }

    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (L2) {
                System.out.println("Thread 2: Holding Lock 2");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e2) {
                    System.out.println("e2");
                }
                System.out.println("Thread 2: Waiting for Lock 1...");
                synchronized (L1) {  // Fixed: Should be L1 instead of L2
                    System.out.println("Thread 2: Holding Lock 2 & 1");
                }
            }
        }
    }
}
