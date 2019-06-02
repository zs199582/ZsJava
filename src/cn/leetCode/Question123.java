package cn.leetCode;

public class Question123 {
    //暴力递归，会超时，写在这里是为了让大家更好的理解动态规划的代码

    public int maxProfit(int[] prices) {
        return f(prices, 0, 0, 0);
    }

    /**
     *
     * @param prices
     * @param i 当前考虑第几天
     * @param hasStock 是否有股票在手
     * @param counts 已经交易的次数（每买一次股票就加一）
     * @return
     */
    private int f(int[] prices, int i, int hasStock, int counts) {
        // 如果已经买了两次股票，并且手里已经没有股票了，那么后面的天数不需要考虑
        if(i >= prices.length || (counts >= 2 && hasStock < 1))
            return 0;
        // 如果手里有股票，我可以选择卖或者不卖
        if(hasStock > 0)
            return  Math.max(prices[i] + f(prices, i+1, 0, counts), f(prices, i+1, 1, counts));
        // 如果没有股票，我可以选择买或者不买
        return Math.max(-prices[i] + f(prices, i+1, 1, counts+1), f(prices, i+1, 0, counts));
    }
    //动态规划 时间复杂度O(n)

    public int maxProfit1(int[] prices) {
        int m = prices.length;
        int[][][] dp = new int[m+1][2][3];  //2:是否持有股票0，1  3:买入股票次数 0，1，2
        for(int i = m-1; i >= 0; i--) {
            for(int j = 1; j >= 0; j--) {
                for(int k = 2; k >= 0; k--) {
                    if(k == 2 && j == 0)   //如果买入两次且不持有股票
                        continue;
                    if(j > 0)             //如果持有股票，买入两次以下
                        dp[i][j][k] = Math.max(prices[i] + dp[i+1][0][k],
                                dp[i+1][1][k]);
                    else                 //如果不持有股票
                        dp[i][j][k] = Math.max(-prices[i] + dp[i+1][1][k+1],
                                dp[i+1][0][k]);
                }
            }
        }
        return dp[0][0][0];
    }
}
