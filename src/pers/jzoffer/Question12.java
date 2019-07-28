package pers.jzoffer;

import org.junit.Test;

public class Question12 {
    //回溯法 问一个二维矩阵是否包含一条字符串的路径
    public boolean hasPath(char[][] origin,String target){
        //a b t g
        //c f c s
        //j d e h
        //target:bfce
        if(origin==null||target==null) return false;
        boolean[][] over = new boolean[origin.length][origin[0].length];
        //初始化是否经过判断数组
        for(int i = 0;i<origin.length;i++){
            for(int j = 0;j<origin[0].length;j++){
                over[i][j] = false;
            }
        }
        char[] targetChar = target.toCharArray();
        boolean hasPath = false;
        int pathLength = 0; //已经找到的路径的长度
        int row = origin.length;  //行数
        int column = origin[0].length; //列数
        //遍历二维数组，以每个位置为头，判断是否有合适的路径
        //这里可能效率有点低，可以先遍历一次数组，记录字符串头字符所在的位置，然后在这几个位置中找
        for (int i = 0; i <row; i++) {
            for(int j = 0;j<column;j++){
                //主判断函数
                hasPath = hasPathCore(origin,i,j,targetChar,pathLength,over);
                if(hasPath) return true;
            }
        }
        return false;
    }
    public boolean hasPathCore(char[][] origin,int row,int column,char[] target,int pathLength,boolean[][] over){
        if(pathLength == target.length) return true;
        boolean hasPath = false;
        int rowCount = origin.length;
        int columnCount = origin[0].length;
        if(row<rowCount&&row>=0&&column<columnCount&&column>=0&&origin[row][column]==target[pathLength]&&!over[row][column]){
            pathLength++;
            over[row][column] = true;
            //判断上下左右是否有合适路径
            hasPath = hasPathCore(origin,row+1,column,target,pathLength,over)
            |hasPathCore(origin,row,column+1,target,pathLength,over)
            |hasPathCore(origin,row-1,column,target,pathLength,over)
            |hasPathCore(origin,row,column-1,target,pathLength,over);

            //如果上下左右都没有正确地路径，就退回到上一个位置
            if(!hasPath){
                over[row][column] = false;
                pathLength--;
            }
        }
        return hasPath;
    }
    @Test
    public void test(){
        //先写一个测试方法
        char[][] origin = new char[3][4];
        char[] row1 = {'a','b','t','g'};
        char[] row2 = {'c','f','c','s'};
        char[] row3 = {'j','d','e','h'};
        origin[0] = row1;
        origin[1] = row2;
        origin[2] = row3;
        System.out.println(hasPath(origin,"bdce"));
    }
}
