package pers.jzoffer;
//丑数
public class Question49 {
    public static void main(String[] args)
    {
        int num= Question49.GetUglyNumber_Solution2(0);
        System.out.println(num);
    }
    public static int GetUglyNumber_Solution(int index) {
        //return 0;
        if(index<=0) return 0;
        int number = 0;
        int uglyNumCount = 0;
        //判断每一个数是否为丑数
        while(uglyNumCount<index)
        {
            number++;
            if(isUgly(number))
            {
                uglyNumCount++;
            }
        }
        return number;
    }
    //判断是否为丑数
    public static boolean isUgly(int num)
    {
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1;
    }
    public static int GetUglyNumber_Solution2(int index) {
        String str = "ss";
        char[] chars = str.toCharArray();
        if(index==0) return 0;
        int[]uglyNums = new int[index+1];
        uglyNums[0] = 1;
        int multiCalCount = 0;
        int nowUglyNumCount = 1;
        int uglyNum2 = 0;
        int uglyNum3 = 0;
        int uglyNum5 = 0;
        for(int i = 1;i<=index;i++)
        {
            while(uglyNum2<=uglyNums[nowUglyNumCount-1]&&multiCalCount<nowUglyNumCount)
            {
                uglyNum2 = 2*uglyNums[multiCalCount];
                multiCalCount++;
            }
            multiCalCount = 0;
            while(uglyNum3<=uglyNums[nowUglyNumCount-1]&&multiCalCount<nowUglyNumCount)
            {
                uglyNum3 = 3*uglyNums[multiCalCount];
                multiCalCount++;
            }
            multiCalCount = 0;
            while(uglyNum5<=uglyNums[nowUglyNumCount-1]&&multiCalCount<nowUglyNumCount)
            {
                uglyNum5 = 5*uglyNums[multiCalCount];
                multiCalCount++;
            }
            uglyNums[i] = min(uglyNum2,uglyNum3,uglyNum5);
            nowUglyNumCount++;
        }
        return uglyNums[index-1];
    }
    public static int min(int a,int b,int c)
    {
        int min = a;
        if(b<a) min = b;
        if(c<min) min = c;
        return min;
    }
}
