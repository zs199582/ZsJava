package pers.jzoffer;

import org.junit.Test;

public class Question10 {
    //斐波那契数列
    //求斐波那契数列的第n项
    @Test
    public void test()
    {
        System.out.println(Fibonacci2(6));
    }
    //采用递归解法，当n很大的时候，栈有可能溢出
    public Integer Fibonacci(int n){
        if(n <= 0) return 0;
        if(n==1||n==2) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    //从下自上的方法，记录之前的计算结果  时间复杂度O(n)
    //1 1 2 3 5 8 13
    public Integer Fibonacci2(int n){
        if(n<=0) return 0;
        if(n==1||n==2) return 1;
        int pre = 1;
        int aft = 2;
        int sum = 2;
        for (int i = 3; i <n ; i++) {
            sum = pre+aft;
            pre = aft;
            aft = sum;
        }
        return sum;
    }
    //题目二 青蛙跳台阶问题
    //一只青蛙一次可以跳上一个台阶或者两个台阶，求该青蛙跳上一个n级台阶总共有多少种跳法
    //就是斐波那契数列
    //如果改成青蛙一次可以跳1级，也可以跳2级，。。。也可以跳n级，问跳上一个n级的台阶总共有多少种跳法。
    // f(n) = pow(2,n-1)
}
