package cn.javaSE;

import sun.nio.ch.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class SEThread {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
//        CallableTest callableTest = new CallableTest();
//        FutureTask<Integer> ft = new FutureTask(callableTest);
//        Thread thread = new Thread(ft);
//        thread.start();
//        FirstThread firstThread = new FirstThread();
//        firstThread.start();
//        while(true)
//        {
//            System.out.println(ft.get());
//            Thread.sleep(500);
//        }
//        SynchronizedExample e1 = new SynchronizedExample();
//        SynchronizedExample e2 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func2());
//        executorService.execute(() -> e2.func2());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        FirstThread firstThread = new FirstThread();
        RunTest runTest = new RunTest(firstThread);
        firstThread.start();
        Thread thread = new Thread(runTest);
        thread.start();
        Thread.sleep(2000);
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(thread.getState());
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
        Integer i01 = 59;
        Integer i03 =Integer.valueOf(59);
        Integer i04 = new Integer(59);
    }
}
class FirstThread  extends Thread
{
    private int counter = 0;
    public void run()
    {
        synchronized (this)
        {
            System.out.println("a."+counter++);
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class RunTest implements Runnable
{
    private FirstThread firstThread;

    RunTest(FirstThread firstThread)
    {
        this.firstThread = firstThread;
    }
    public void run()
    {
        for(int i = 0;i<10;i++)
        {
            try {
                //firstThread.notify();
                System.out.println("b." + i);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
class CallableTest implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        return 123;
    }
}
class SynchronizedExample {
    public void func2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");

            }
        }
    }
}
