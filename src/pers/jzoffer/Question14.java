package pers.jzoffer;

import org.junit.Test;

public class Question14 {
    //剪绳子
    //1.使用动态规划的思想
    //给一根长度为n的绳子，把绳子剪成m段 问m段的最大乘积是多少
    public int maxMultiple(int length){
        //参数检查
        if(length<=1) return -1;
        if(length==2) return 2;
        if(length == 3) return 3;
        int[] max = new int[length+1];
        max[0] = 0;
        max[1] = 1;
        max[2] = 2;
        max[3] = 3;
        for(int i = 4;i<=length;i++){
            int maxMultiple = 0;
            for(int j = 1;j<=i/2;j++){
                maxMultiple = Math.max(maxMultiple,max[j]*max[i-j]);
            }
            max[i] = maxMultiple;
        }
        return max[length];
    }
    //2.除了动态规划，也可以使用贪心算法

    @Test
    public void test(){
        System.out.println(maxMultiple(8));
    }
}
