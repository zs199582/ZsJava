package pers.jzoffer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Question3 {
    //数组中的重复的数字
    //[2,3,1,0,2,5,3]
    //返回[2,3]
    public static int[] getDuplicate(int[] nums){
        if(nums==null) return null;
        //用hashset存放数据，遍历nums向hashset中添加
        HashSet<Integer> hashSet = new HashSet<Integer>();
        List<Integer> target = new ArrayList<Integer>();
        for (int num:nums
             ) {
            if(!hashSet.contains(num)){
                hashSet.add(num);
            }
            else target.add(num);
        }
        int[] duplicateNums = new int[target.size()];
        for (int i = 0; i <target.size() ; i++) {
            duplicateNums[i] = target.get(i);
        }
        return duplicateNums;
    }
    //优化解法  找出数组中任意一个重复的数字，如果没有，返回false
    public boolean getDuplicate2(int[] nums,int duplicateNum){
        if(nums == null) return false;
        int temp;
        //[2,3,1,6,2,5,3]
        for (int i = 0; i <nums.length ; i++) {
            while(nums[i]!=i){
                if(nums[nums[i]]==nums[i])
                {
                    duplicateNum = nums[i];
                    return true;
                }
                //swap交换
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return false;
    }
    @BeforeClass
    public static void beforeClassTest(){
        System.out.println("beforeClassTest");
    }
    @Before
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    //上面的算法对数组进行了修改，如果要求不能对数组进行修改
    @Test
    public void getDuplicationTest(){
        System.out.println(getDuplication4(new int[]{1,2,3,4,5,2}));
    }
    //不能对数组进行修改条件下的算法
    public int getDuplication4(int[] nums){
        if(nums==null) return -1;
        int start = 1;
        int end = nums.length-1;
        int mid;
        //二分查找
        while(end>=start){
            mid = start+((end-start)>>1);
            int count = countRange(nums,start,mid);
            if(start==end)
            {
                if(count>1) return start; //发现有一个数字重复出现
                else break;
            }
            if(count>(mid-start+1))
                end = mid;
            else
                start = mid+1;
        }
        return -1;
    }
    public int countRange(int[] nums,int start,int end){
        //int length = end-start+1;
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<=end&&nums[i]>=start)
                ++count;
        }
        return count;
    }
}
