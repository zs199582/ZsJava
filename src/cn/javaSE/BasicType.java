package cn.javaSE;

import org.junit.jupiter.api.Test;

public class BasicType {
    /**
     * 基本数据类型(8个)
     * byte   8
     * char   16
     * short  16
     * int    32
     * float  32
     * long   64
     * double 64
     * boolean ~
     */

    /**
     *Default Value
     * byte    0
     * short   0
     * int     0
     * long    0L
     * float   0.0f
     * double  0.0d
     * char    "\u0000"
     * String(或者任何一个引用型) null
     * boolean  false
     */
    /**********
     * 缓存池
     *********/
    @Test
    public void cacheTest()
    {
        Integer integerA = new Integer(11);
        Integer integerB = new Integer(11);
        System.out.println(integerA == integerB);
        Integer integerC = Integer.valueOf(11);
        Integer integerD = Integer.valueOf(11);
        System.out.println(integerC == integerD);
    }
    /**
     * 基本类型对应的缓冲池如下：
     * boolean values true and false
     * all byte values
     * short values between -128 and 127
     * int values between -128 and 127
     * char in the range \u0000 to \u007F
     * 在使用这些基本类型对应的包装类型时，就可以直接使用缓冲池中的对象。
     */
}
