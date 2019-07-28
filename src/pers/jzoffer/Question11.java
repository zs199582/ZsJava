package pers.jzoffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

//查找和排序算法
//重点 二分查找，快排，堆排序，归并排序
public class Question11 {
    //题目：实现一个排序算法，要求时间复杂度为O（n）
    //对公司的员工的年龄排序，
    //
    public void sort(Integer[] nums){
        //快排 Ologn
        int ages = 100;
        int[] timesOfAges = new int[ages];
        //统计每一个年龄值有多少个员工,存到数组中
        for (int i = 0; i <nums.length ; i++) {
            timesOfAges[nums[i]]++;
        }
        //
        int index = 0;
        for (int i = 0; i <ages ; i++) {
            while(timesOfAges[i]-->0)
                nums[index++] = i;
        }
    }
    @Test
    public void test(){
//        Integer[] ages = {1,53,23,4,5,42,44,54,54,66,23};
//        sort(ages);
//        for (Integer i: ages) {
//            System.out.print(i.toString()+' ');
//        }
        int[] ages = {1,0,1,1,1};
        System.out.println(getMin(ages));
    }
    //第二题 旋转数组的最小数字
    //输入递增排序数组的一个旋转，输出旋转数组的最小元素
    public int getMinEle(int[] nums){
        //数组为34512 最小元素为1
        //可以从头到尾遍历，但是效率O（n）太低
        //可以用二分的思想
        if(nums==null) return -1;
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)>>1;
        while(Math.abs(start-end)>1){
            //调整查找的范围 缩小范围
            if(nums[mid]<nums[start])
                end = mid;
            else if(nums[mid]>nums[end])
                start = mid;
            //重新计算mid
            mid = (start+end)>>1;
        }
        return Math.min(nums[start],nums[end]);
    }
    //如果两个指针位置相等的情况，也就是数组中的数字存在重复相等的情况
    public int getMin(int[] nums){
        //10111
        if(nums==null) return -1;
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)>>1;
        while(Math.abs(start-end)>1){
            //调整查找的范围 缩小范围
            if(nums[mid]<nums[start])
                end = mid;
            else if(nums[mid]>nums[end])
                start = mid;
            //如果前中后三个指针处的值相等
            else if(nums[mid]==nums[start]&&nums[mid]==nums[end])
                return minOrder(nums,start,end);
            //重新计算mid
            mid = (start+end)>>1;
        }
        return Math.min(nums[start],nums[end]);
    }
    public int minOrder(int[]nums,int start,int end){
        int temp = nums[start];
        for(int i = start+1;i<=end;i++){
            if(nums[i]<temp) return nums[i];
            else temp = nums[i];
        }
        return -1;
    }
}
