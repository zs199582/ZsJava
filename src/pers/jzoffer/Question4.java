package pers.jzoffer;

import org.junit.Test;

public class Question4 {
    //面试题4 二维数组中的查找
    //二维数组每一行按照从左到右递增，从上到下递增 判断数组中是否含有该整数
    public boolean searchArray(Integer[][] nums,Integer target){
        if(nums == null) return false;
        int rowLength = nums.length;
        int columnLength = nums[0].length;
        //初始数值位置为二维数组的左下角
        int row = rowLength-1,column =1;
        while(row>=0&&column<=columnLength-1)
        {
            if(target==nums[row][column]) return true;
            if(target > nums[row][column]) column++;
            else row--;
        }
        return false;
    }
    @Test
    public void test(){
        Integer[][] nums = new Integer[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(searchArray(nums,15));
    }
}
