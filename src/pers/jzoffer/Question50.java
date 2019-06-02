package pers.jzoffer;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.HashMap;

public class Question50 {
    public static void main(String[] args)
    {
        Question50 q = new Question50();
        System.out.println(q.FirstNotRepeatingChar(""));
    }
    public int FirstNotRepeatingChar(String str) {
        //第一个想法：变成char数组，循环每个字符，在剩余的字符中找是否存在与这个字符相同的字符O(n2)
        if(str=="") return -1;
        char[] chars = str.toCharArray();
        char judgeChar;
        boolean isRepeat;
        for(int judgeIndex = 0;judgeIndex<chars.length;judgeIndex++)
        {
            isRepeat = false;
            judgeChar = chars[judgeIndex];
            for(int otherIndex = 0;otherIndex<chars.length;otherIndex++)
            {
                if(otherIndex == judgeIndex) continue;
                if(judgeChar == chars[otherIndex])
                {
                    isRepeat = true;
                    break;
                }
            }
            if(isRepeat) continue;
            else return judgeIndex;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        return -1;

    }
}
