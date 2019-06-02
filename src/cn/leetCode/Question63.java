package cn.leetCode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class Question63 {
    public static void main(String[]args)
    {
        Question63 question63 = new Question63();
        int[][] path = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(question63.uniquePathsWithObstacles(path));
    }
    //动态规划
    //region 我的原始解法
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid.length;
        int height = obstacleGrid[0].length;
        int[][]pathCount = new int[width][height];
        int leftPath,topPath;
        boolean leftBlock = false;
        boolean topBlock = false;
        for(int i = 0;i<width;i++)
        {
            for(int j = 0;j<height;j++)
            {
                if(i==0) //最左侧
                {
                    if(j==0&&obstacleGrid[0][0]==1)
                    {
                        leftBlock = true;
                        topBlock = true;
                    }
                    if(obstacleGrid[i][j]!=1&&leftBlock!=true)
                        pathCount[i][j] = 1;
                    else
                    {
                        leftBlock = true;
                        pathCount[i][j] = 0;
                    }
                }
                else if(j==0) //第一行
                {
                    if(obstacleGrid[i][j]!=1&&topBlock!=true)
                        pathCount[i][j] = 1;
                    else {
                        topBlock = true;
                        pathCount[i][j] = 0;
                    }
                }
                else
                {
                    leftPath = obstacleGrid[i-1][j]==1?0:pathCount[i-1][j];
                    topPath = obstacleGrid[i][j-1]==1?0:pathCount[i][j-1];
                    pathCount[i][j] = leftPath+topPath;
                }
            }
        }
        return obstacleGrid[width-1][height-1]==1?0:pathCount[width-1][height-1];
    }
    //endregion
    //region
    //endregion
}
