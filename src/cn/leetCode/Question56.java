package cn.leetCode;

import java.util.*;

/**
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Question56 {
    public static void main(String[]args)
    {
//        int[][] intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
//        int[][] intervals = new int[][]{{1,4},{0,4}};
        int[][] intervals = new int[][]{{1,3},{2,4},{8,10},{3,7}};
//        int[][] intervals = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        Question56 question56 = new Question56();
        int[][] target =  question56.merge(intervals);
        for (int[] a:target
             ) {
            System.out.println(Arrays.toString(a));
        }
        List<Interval> list = new ArrayList<>();
        Interval interval = new Interval(1,3);
        list.add(interval);
        interval = new Interval(2,6);
        list.add(interval);
        interval = new Interval(15,18);
        list.add(interval);
        interval = new Interval(8,10);
        list.add(interval);
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
    }
    public int[][] merge(int[][] intervals) {
        //把首元素升序排列
        int rowCount = intervals.length;
        List<int[]> list = new ArrayList();
        int[][] arrs = intervals;
        quickSort(arrs, 0, arrs.length - 1);
        //
        boolean splitDone = true;
        int index = 0;
        while (index < rowCount) {
            int starIndex = index; //记录融合判断的开始位置
            int max = arrs[index][1];
                while(index<rowCount)
                {
                    if(index+1<rowCount&&!less(max, intervals[index + 1][0]))
                    {
                        max = Math.max(max,arrs[index+1][1]);
                        index++;
                        splitDone = false;
                        continue;
                    }
                    list.add(new int[]{intervals[splitDone==true?index:starIndex][0],splitDone==true?intervals[index][1]:getMax(intervals,starIndex,index)});
                    splitDone = true;
                    index++;
                    break;
                }
                //填入list
//                list.add(new int[]{intervals[index][0], Math.max(intervals[index][1], intervals[index + 1][1])});
//            else {
//                list.add(intervals[index]);
//                index++;
            }

        int targetLength = list.size();
        int[][] target = new int[targetLength][];
        for(int i = 0;i<targetLength;i++)
            target[i] = list.get(i);
        return target;

    }
    public int getMax(int[][] arrs,int start,int end)
    {
        int max = arrs[start][1];
        for(int i = start;i<=end;i++)
        {
            max = Math.max(max,arrs[i][1]);
        }
        return max;
    }
    public void quickSort(int[][]arrs,int left,int right)
    {
        if(left>=right) return;
        int splitGuard = partition(arrs,left,right);
        System.out.println(splitGuard);
        quickSort(arrs,left,splitGuard-1);
        quickSort(arrs,splitGuard+1,right);
    }
    public int partition(int[][]arrs,int left,int right)
    {
        int[] temp = arrs[left];
        while(left!=right)
        {
            while(right>left&&!less(arrs[right][0],temp[0]))
                right--;
            arrs[left] = arrs[right];
            while(right>left&&less(arrs[left][0],temp[0]))
                left++;
            arrs[right] = arrs[left];
        }
        arrs[left] = temp;
        return left;
    }
    public boolean less(int a,int b) {
        return a < b;
    }
}
class Interval{
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
