package pers.jzoffer;

public class Question43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1) return 0;
        int totalCount = 0;
        String numToStr = null;
        char[] chars;
        for(int index = 1;index<=n;index++)
        {
            numToStr = String.valueOf(index);
            chars = numToStr.toCharArray();
            for(char c:chars)
            {
                if(c=='1')
                    totalCount++;
            }
        }
        return totalCount;
    }
}
