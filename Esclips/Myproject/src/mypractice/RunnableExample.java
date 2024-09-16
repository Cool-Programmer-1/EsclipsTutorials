package mypractice;

class MyRunnable implements Runnable {
public void run() {
for (int i = 0; i < 5; i++) {
System.out.println("Thread is running: " + i);
try {
Thread.sleep(1000); 
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
}


public class RunnableExample {
public static void main(String[] args) {
MyRunnable myRunnable = new MyRunnable();
Thread thread = new Thread(myRunnable);
thread.start();
for (int i = 0; i < 5; i++) {
System.out.println("Main thread: " + i);
try {
Thread.sleep(500); 
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
}
