package pers.zhaohang;

import pers.jzoffer.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Question26 {
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] ints = toIntArr(s);// s="1 2 3 4"
        Question26 question26 = new Question26();
        System.out.print(question26.getMaxProfit(ints));
    }
    private static int[] toIntArr(String str) {
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = new Integer(strings[i]);
        }
        return arr;
    }
    public int getMaxProfit(int[] price)
    {
        if(price == null||price.length == 0) return 0;
        int end = price.length-1;
        int start = 0;
        int min = price[0];
        int max = price[end];
        while(start<=end)
        {
            if(price[start]<min)
                min = price[start];
            if(price[end]>max)
                max = price[end];
            start++;
            end--;
        }
        return (max-min)>=0?(max-min):0;
    }
}
