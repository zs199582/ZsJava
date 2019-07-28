package cn.designMode.ProducerConsumer;

/**
 * 使用wait()和notifyAll()实现生产者消费者模式
 */
public class ProducerConsumerWithWaitNotify {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread producer1 = new Thread(new Producer(resource),"生产者1");
        Thread producer2 = new Thread(new Producer(resource),"生产者2");
        Thread producer3 = new Thread(new Producer(resource),"生产者3");
        Thread consumer1 = new Thread(new Consumer(resource),"消费者1");
        Thread consumer2 = new Thread(new Consumer(resource),"消费者2");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
    }
}
class Resource{
    //资源
    volatile int num = 0; //资源个数
    private volatile int size = 10; //资源池中允许存放的最多资源
    public synchronized void get(){
        if(num>0){
            num--;
            System.out.println("消费者："+Thread.currentThread().getName()+"消费了一个" +
                    "资源");
            notifyAll();  //通知生产者生产资源？？？??
        }
        else{
            try {
                wait();
                //运行时这里有点问题，
                //当前有：2
                //消费者消费者2进入等待状态  ？？为什么当前有2的时候，仍然进入了等待状态
                System.out.println("当前有："+num);
                System.out.println("消费者"+Thread.currentThread().getName()+"进入等待状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void put(){
        if(num>=size){
            try{
                wait();
                System.out.println(Thread.currentThread().getName()+"线程进入等待");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        else{
            num++;
            System.out.println(Thread.currentThread().getName()+"增加了一个商品");
            notifyAll();
        }
    }
}
class Producer implements Runnable{
    //生产者线程
    private Resource resource;
    public Producer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        while(true) {
            try {
                resource.put();
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    //消费者线程
    private Resource resource;
    public Consumer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while(true) {
            try {
                resource.get();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
