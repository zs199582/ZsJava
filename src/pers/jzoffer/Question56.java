package pers.jzoffer;

import com.sun.xml.internal.bind.v2.runtime.property.StructureLoaderBuilder;

import java.util.ArrayList;
import java.util.List;

public class Question56 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2,3,3,4,4,1,23};
        System.out.println(LeftRotateString("",3));
    }
    public static String LeftRotateString(String str,int n) {
        if(str.equals("")||n<=0) return str;
        int length = str.length();
        n=n%length;
        String str1 = str.substring(0,n);
        String str2 = str.substring(n,length);
        return str2+str1;
    }
    public static int getNumAppearsOnce(int[] nums){

        if(nums == null || nums.length <= 2){
            throw new IllegalArgumentException("nums size must bigger than 2");
        }

        int result = 0;
        for(int i=0;i<nums.length;i++){
            result ^= nums[i];
        }
        String str = "sss";

        return result;
    }
}
