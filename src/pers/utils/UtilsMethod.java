package pers.utils;

import java.util.*;

public class UtilsMethod {

    public int maxProfit(int[] prices) {
        if(prices == null||prices.length==0) return 0;
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<prices.length;i++)
        {
            max = Math.max(prices[i]-min,max);
            min = Math.min(prices[i],min);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] ints = toIntArr(s);// s="1 2 3 4"

        List<int[]> list = new ArrayList<>();
        allSort(ints, 0, ints.length - 1, list);

        List<LinkedList<Integer>> list1 = new ArrayList<>();
        combine(ints, list1);
        printNoSp(list1.toString());
        printWithSp(list1.toString());
    }

    //带空格的字符串转数组
    public static int[] toIntArr(String str) {
        String[] strings = str.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = new Integer(strings[i]);
        }
        return nums;
    }

    //全排列
    public static void allSort(int[] array, int begin, int end, List<int[]> list) {
        if (begin == end) {
            list.add(Arrays.copyOf(array, array.length));
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end, list);
            swap(array, begin, i);
        }
    }

    //交换
    public static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    //全组合
    public static void combine(int[] chs, List<LinkedList<Integer>> comb) {
        if (chs.length == 0) return;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list, comb);
        }
    }

    public static void combine(int[] chs, int begin, int number, LinkedList<Integer> list, List<LinkedList<Integer>> comb) {
        if (number == 0) {
            LinkedList<Integer> l = new LinkedList<>(list);
            comb.add(l);
            return;
        }
        if (begin == chs.length) {
            return;
        }
        list.push(chs[begin]);
        combine(chs, begin + 1, number - 1, list, comb);
        list.pop();
        combine(chs, begin + 1, number, list, comb);
    }

    //无空格输出列表/集合
    public static void printNoSp(String s) {
        s = s.replace(", ", "");
        s = s.substring(1, s.length() - 1);
        System.out.println(s);
    }

    //有空格输出列表/集合
    public static void printWithSp(String s) {
        s = s.replace(",", "");
        s = s.substring(1, s.length() - 1);
        System.out.println(s);
    }
}
