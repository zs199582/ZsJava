package pers.jzoffer;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.Iterator;

public class Question40 {
    public static void main(String[] args)
    {
        Question40 question40 = new Question40();
        int[] num = {1,2,3,4,5,6,7,8};
        Iterator iterator = question40.GetLeastNumbers_Solution(num,8).iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null||k>input.length||k<0) return new ArrayList<>();
        //当允许交换数组中数字的顺序时可以使用partition函数
        ArrayList<Integer> target = new ArrayList<>();
        int start = 0;
        int end = input.length-1;
        int pivot = partition(input,0,input.length-1);
        while(pivot!=k-1)
        {
            if(pivot>k-1)
            {
                end = pivot-1;
                pivot = partition(input,start,end);
            }
            else
            {
                start = pivot+1;
                pivot = partition(input,start,end);
            }
        }
        for(int index = 0;index<k;index++)
        {
            target.add(input[index]);
        }
        return target;
    }
    public int partition(int[] array,int start,int end)
    {
        if(start>end) return -1;
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
