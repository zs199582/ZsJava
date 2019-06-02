package cn.javaThread;

public class test {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");
//        MyThread myThread = new MyThread();
//        Thread t1 = new Thread(myThread,"t1");
//        Thread t2 = new Thread(myThread,"t2");
//        Thread t3 = new Thread(myThread,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
    static class MyThread extends Thread {
        static int num = 10;

        MyThread(String t2) {
            super(t2);
        }

        @Override
        public void run() {
            synchronized (this.getClass()) {
                while (num > 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + num--);
                }
            }
        }
    }
}
