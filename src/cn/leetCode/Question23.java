package cn.leetCode;

public class Question23 {
    public static void main(String[]args)
    {
        int[] prices = new int[]{1,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length == 0) return 0;
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 1;i<prices.length;i++)
        {
            leftMax = maxProfit(prices,0,i);
            rightMax = maxProfit(prices,i+1,prices.length-1);
            max = Math.max(max,leftMax+rightMax);
        }
        return max;
    }
    public static int maxProfit(int[] prices,int start,int end) {
        if(start>=end) return 0;
        if(prices == null||prices.length==0) return 0;
        int min = prices[start];
        int max = Integer.MIN_VALUE;
        for(int i = start;i<=end;i++)
        {
            max = Math.max(prices[i]-min,max);
            min = Math.min(prices[i],min);
        }
        return max;
    }
}
