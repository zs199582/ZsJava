package pers.jzoffer;

import org.junit.Test;

import java.util.Arrays;

public class Question21 {
    //调整数组使奇数位于偶数前面
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使所有奇数位于数组的前半部分，
    //所有偶数位于数组的后半部分
    //1,2,4,3,8,6,4
    public void reorderOddEven(int[]nums){
        if(nums==null) return;
        int pre = 0;
        int aft = nums.length-1;
        while(pre<aft)
        {
            //定位左边的指针到一个偶数
            while(nums[pre]%2==1&&pre<aft) pre++;
            //
            while(nums[aft]%2==0&&aft>pre) aft--;
            swap(nums,pre,aft);
        }
    }
    public void swap(int[]nums,int indexA,int indexB){
        int temp = nums[indexB];
        nums[indexB] = nums[indexA];
        nums[indexA] = temp;
    }
    @Test
    public void test(){
        int[] num = {1,2,3,4,5,6,7,8};
        reorderOddEven(num);
//        swap(num,0,5);
        System.out.println(Arrays.toString(num));
    }
}
