package mypractice;

class Bank extends Thread {
    private static volatile int bal = 100000;
    private int withdraw;

    Bank(int withdraw) {
        this.withdraw = withdraw;
    }

    @Override
    public synchronized void run() {
        String nameString = Thread.currentThread().getName();
        if (withdraw <= bal) {
            System.out.println(nameString + " withdraw money");
            bal = bal - withdraw;
            System.out.println("Remaining balance: " + bal);
        } else {
            System.out.println(nameString + " Insufficient Balance");
        }
    }
}

class Customer {

    public static void main(String[] args) {
        Bank obj1 = new Bank(20000);
        Bank obj2 = new Bank(20000);
        Bank obj3 = new Bank(20000);
        Bank obj4 = new Bank(20000);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);

        t1.setName("Akash Pati");
        t2.setName("Simanchal Pati");
        t3.setName("Amar Kumar Pati");
        t4.setName("Kamal Kumari Satapathy");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
