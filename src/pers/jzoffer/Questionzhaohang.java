package pers.jzoffer;

public class Questionzhaohang {
    public static void main(String[]args)
    {
        Questionzhaohang questionzhaohang = new Questionzhaohang();
        System.out.println(questionzhaohang.minExchangeTimes("CCDCC"));
    }
    public int minExchangeTimes(String str)
    {
        if(str == null) return 0;
        char[] array = str.toCharArray();
        int left = getLeftCTotalCount(array);
        int right = getRightCTotalCount(array);
        return left<right?left:right;
    }
    public int getLeftCTotalCount(char[] array)
    {
        int length = array.length;
        if(length == 0) return 0;
        int sum = 0;
        int CCount = 0;
        for(int i = 0;i<length;i++)
        {
            if(array[i]=='C') CCount++;
            else if(array[i]=='D') sum+=CCount;
        }
        return sum;
    }
    public int getRightCTotalCount(char[] array)
    {
        int length = array.length;
        if(length == 0) return 0;
        int sum = 0;
        int CCount = 0;
        for(int i = --length;i>=0;i--)
        {
            if(array[i]=='C') CCount++;
            else if(array[i]=='D') sum+=CCount;
        }
        return sum;
    }
}
