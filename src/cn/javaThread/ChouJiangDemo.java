package cn.javaThread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
 */
public class ChouJiangDemo {
    public static void main(String[] args)
    {
        ChouJiang chouJiang = new ChouJiang();
        Thread thread1 = new Thread(chouJiang,"抽奖箱1");
        Thread thread2 = new Thread(chouJiang,"抽奖箱2");
        thread1.start();
        thread2.start();

    }
}
class ChouJiang implements Runnable
{
    private int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
    private ArrayList<Integer> arrList;
    private int index;
    public ChouJiang()
    {
        arrList = new ArrayList<Integer>();
        for (int x:arr
             ) {
            arrList.add(x);
        }
    }
    @Override
    public void run() {
        while(true)
        {
            synchronized(this.arrList) //这里应该锁什么比较好？
            {
                if(arrList.size()!=0) {
                    index = (int)(arrList.size() * Math.random());
                    System.out.println(Thread.currentThread().getName()+":"+ arrList.get(index));
                    arrList.remove(index);
                }
            }
        }
    }
}
/**
 * 怎么实现一个线程抽过奖之后第二个线程抽奖，两个线程交替抽奖
 */
