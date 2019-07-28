package pers.jzoffer;

import org.junit.Test;

import java.lang.reflect.Method;

public class Question13 {
    //机器人的运动范围
    //有一个m*n的矩阵，机器人从（0，0）开始移动，每次可以上下左右移动一格，但不能进入
    //坐标的数位之和大于k的格子，例如k=18时，可以进入（35，37） 但是不能进入（35，38） 3+5+3+8=19
    //输出机器人最多能够到达多少个格子
    public int movingSteps(int k,int m,int n){
        //参数检查
        if(k<0) return 0;
        int maxStep = 0;
        //是否经过的判断数组，初始化
        Boolean[][] over = new Boolean[m][n];
        for(int i = 0;i<over.length;i++){
            for(int j = 0;j<over[0].length;j++){
                over[i][j] = false;
            }
        }
        //判断当前位置是否能走（getSum<=k&&over==false）
        int currentRow = 0;
        int currentColumn = 0;
        //如果能走，step+1，当前位置over=true，判断上下左右是否能走 如果不能走，撤回（）
        return movingStepsCore(k,m,n,0,0,over);
    }
    public int movingStepsCore(int k,int rows,int columns,int currentRow,int currentColumn,Boolean[][] over){
        //检查over数组是否越界
        if(currentColumn<0||currentRow<0) return 0;
        //over = checkForOver(over,currentRow,currentColumn);
        int maxStep = 0;
        //判断当前位置
        if(currentRow<rows&&currentRow>=0&&currentColumn<columns&&currentColumn>=0&!over[currentRow][currentColumn]&&getSum(currentRow,currentColumn)<=k){
            over[currentRow][currentColumn] = true;
            maxStep = 1+movingStepsCore(k,rows,columns,+1,currentColumn,over)+
                    movingStepsCore(k,rows,columns,currentRow,currentColumn+1,over)+
                    movingStepsCore(k,rows,columns,currentRow-1,currentColumn,over)+
                    movingStepsCore(k,rows,columns,currentRow,currentColumn-1,over);
        }
        return maxStep;
    }

    /**
     * 判断over数组是否需要扩容
     * @param over
     * @param currentRow
     * @param currentColumn
     */
    private Boolean[][] checkForOver(Boolean[][] over, int currentRow, int currentColumn) {
        int row = over.length;
        int column = over[0].length;
        if(row-1<currentRow||column-1<currentColumn){
            Boolean[][] newOver = new Boolean[row*2][column*2];
            for(int i = 0;i<row;i++){
                for (int j = 0; j <column; j++) {
                    newOver[i][j] = over[i][j];
                }
            }
            return newOver;
        }
        return over;
    }

    public int max(int a,int b,int c,int d)
    {
        return Math.max(Math.max(a,b),Math.max(c,d));
    }
    public int getSum(int x,int y){
        //35 37
        int sum = 0;
        while(x!=0){
            sum+=x%10;
            x = x/10;
        }
        while(y!=0){
            sum+=y%10;
            y = y/10;
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(movingSteps(18,15,15));
       // System.out.println(getSum(0,1));
    }
}
