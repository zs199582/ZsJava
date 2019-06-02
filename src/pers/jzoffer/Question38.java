package pers.jzoffer;
import java.util.*;

public class Question38 {
    public static void main(String[] args)
    {
        String str = "aa";
        Question38 question38 = new Question38();
        ArrayList<String> list = question38.Permutation(str);
        for (String strs:
             list) {
            System.out.println(strs);
        }

    }
    public ArrayList<String> Permutation(String str) {
        if(str.equals("")) return new ArrayList<>();
        char[] chars = str.toCharArray();
        ArrayList<String> target = new ArrayList<String>();
        permutation(chars,0,target);
        return target;
    }
    public void permutation(char[] chars,int beginIndex,ArrayList<String> target)
    {
        if(beginIndex>=chars.length) target.add(String.valueOf(chars));
        //
        for(int charIndex = beginIndex;charIndex<chars.length;++charIndex)
        {
            swap(chars,charIndex,beginIndex);
            permutation(chars,beginIndex+1,target);
            swap(chars,charIndex,beginIndex);
        }
    }
    public void swap(char[] chars,int firstIndex,int secondIndex)
    {
        char temp = chars[firstIndex];
        chars[firstIndex] = chars[secondIndex];
        chars[secondIndex] = temp;
    }
}
