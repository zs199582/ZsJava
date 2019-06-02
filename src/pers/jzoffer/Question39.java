package pers.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question39 {
    public static void main(String[] args)
    {
        Question39 question39 = new Question39();
        int[] nums = {3,2,1,2};
        System.out.println(question39.MoreThanHalfNum_Solution(nums));

    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        int start = 0;
        int end = array.length-1;
        int pivot = partition(array,0,end);
        int middle = array.length>>1;
        while(pivot!=middle)
        {
            if(pivot<middle)
            {
                pivot = partition(array,pivot+1,end);
            }
            else
            {
                pivot = partition(array,start,pivot-1);
            }
        }
        int ele = array[pivot];
        if(checkMoreThanHalf(array,ele))
            return ele;
        else
            return 0;
    }
    public boolean checkMoreThanHalf(int[] array,int ele)
    {
        int count = 0;
        int halfTotalCount = array.length>>1;
        for(int index = 0;index<array.length;index++)
        {
            if(array[index]==ele)
                count++;
        }
        return count>halfTotalCount;
    }
    public int partition(int[] array,int start,int end)
    {
        if(start>=end) return 0;
        int temp = array[start];
        while(start<end)
        {
            while(start<end&&!less(array[end],temp))
                end--;
            array[start] = array[end];
            while(start<end&&less(array[start],temp))
                start++;
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }
    public boolean less(int valuea,int valueb)
    {
        return valuea<valueb;
    }
}
