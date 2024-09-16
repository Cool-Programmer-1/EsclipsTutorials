package mypractice;



public class ThreadPriorityExample {
public static void main(String[] args) {
Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
Thread thread2 = new Thread(new MyRunnable(), "Thread-2");

thread1.setPriority(Thread.MIN_PRIORITY); 
thread2.setPriority(Thread.MAX_PRIORITY); 

thread1.start();
thread2.start();
}

static class MyRunnable implements Runnable {
public void run() {
System.out.println("Thread: " + Thread.currentThread().getName()
+ ", Priority: " + Thread.currentThread().getPriority());
}
}
}
