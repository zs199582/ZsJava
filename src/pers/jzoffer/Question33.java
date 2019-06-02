package pers.jzoffer;

public class Question33 {
    public static void main(String[]args)
    {
        Question33 question33 = new Question33();
        int[]nums = {4,8,6,12,16,14,10};
        boolean target =  question33.VerifySquenceOfBST(nums);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        return verifySquence(sequence,0,sequence.length-1);
    }
    public boolean verifySquence(int[] sequence,int start,int end)
    {
        if(sequence == null||end<start)
            return false;
        if(start==end) return true;
        int root = sequence[end];
        int i = start;
        for(;i<end;i++)
        {
            if(sequence[i]>root)
                break;
        }
        int j = i;
        for(;j<end;j++)
        {
            if(sequence[j]<root)
                return false;
        }
        boolean left = true;
        if(i>0)
            left = verifySquence(sequence,0,i-1);
        boolean right = true;
        if(j<=end)
            right = verifySquence(sequence,j,end);
        return left&&right;

    }
}
