package cn.javaThread;

public class CommandReorder {
    //指令重排序示例
    private static int a=0;
    private static boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            Thread threada = new Thread(new ThreadA(),"threada");
            Thread threadb = new Thread(new ThreadA(),"threadb");
            threada.start();
            threadb.start();
            //
            try {
                threada.join();
                threadb.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = 0;
            flag = false;
        }

    }
    static class ThreadA implements Runnable
    {
        @Override
        public void run() {
            System.out.println("theada run");
            a = 1;
            flag = true;
        }
    }
    static class ThreadB implements Runnable{
        @Override
        public void run() {
            if(flag)
                a = a*1;
            if(a==1)
                System.out.println("a==0");
        }
    }
}

