package pers.jzoffer;
import org.junit.Test;
public class Question5 {
    @Test
    public void test(){
        StringBuffer sbf = new StringBuffer("we are happy");
        System.out.println(replaceSpace(sbf));
    }
    //替换空格
    //把字符串中的空格替换成“%20” we are happy   we%20are%20happy
    public String stringExchange(String str)
    {
        //新建一个字符串，把原字符串和替换的字符串加到新字符串中
        StringBuffer sbf = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]==' ')
                sbf.append("%20");
            else sbf.append(chars[i]);
        }
        return sbf.toString();

    }
    //上面的方法空间复杂度为O(n) 如果不允许新建字符串，就得在原字符串上修改
    public String replaceSpace(StringBuffer sbf){
        //先遍历一遍字符串，查看有几个空格，新的字符串长度为原长度+2*空格数
        int oldLength = sbf.length();
        int newLength = oldLength;
        for(int i = 0;i<sbf.length();i++){
            if(sbf.charAt(i)==' ')
                newLength+=2;
        }
        //
        sbf.setLength(newLength);
        newLength--;
        char c;
        //从后往前将旧字符串重构，空格替换成%20
        for(int j = oldLength-1;j>=0;j--){
            c=sbf.charAt(j);
            if(c!=' ')
                sbf.setCharAt(newLength--,c);
            else{
                //如果遇到空格了，存入的字符就是%20
                sbf.setCharAt(newLength--,'0');
                sbf.setCharAt(newLength--,'2');
                sbf.setCharAt(newLength--,'%');
            }
        }
        return sbf.toString();
    }
}
