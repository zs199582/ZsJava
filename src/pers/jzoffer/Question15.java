package pers.jzoffer;

import org.junit.Test;

import java.lang.ref.PhantomReference;

public class Question15 {
    //二进制中1的个数
    //输入一个整数，输出该数二进制表示中1的个数。9表示成二进制是1001 有2位是1 如果输入9，输出2
    public int getNumOf1(int num){
        int count = 0;
        while(num != 0)
        {
            if((num&1)==1)
                count++;
            //无符号右移1位
            num = num>>>1;
        }
        return count;
    }
    @Test
    public void test(){
        //System.out.println(getNumOf1(9));
//        Object obj = new Object();
//        PhantomReference<Object> pf = new PhantomReference<Object>(obj,null);
//        obj = null;
        double a = 1/3;
        double b = 1/3;
        if(a==b) System.out.println(a);
    }
}
