package cn.javaThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock lock1 = new ReentrantLock(); //公平锁
    static ReentrantLock lock2 = new ReentrantLock(); //公平锁

    public static void main(String[] args) {

            Thread thread1 = new Thread(new PrintThread(lock1,lock2),"thread1");
            Thread thread2 = new Thread(new PrintThread(lock2,lock1),"thread2");

            thread1.start();
            thread2.start();
        thread1.interrupt();

    }
    static class PrintThread implements Runnable{
        private Lock lock1;
        private Lock lock2;
        public PrintThread(Lock lock1,Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
        }
        @Override
        public void run() {
            try {
                lock1.lockInterruptibly();
                TimeUnit.MILLISECONDS.sleep(10);
                lock2.lockInterruptibly();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            finally{
                lock1.unlock();
                lock2.unlock();
                System.out.println("正常退出");
            }
        }
    }
}
