package cn.javaSE;

import org.junit.jupiter.api.Test;

public class SEString {
    public final int bb = 2;
    public final SEString aa = new SEString();
    @Test
    public void testString()
    {
        String string = new String();
        string.intern();
    }
    class InnerSEString{

    }
    public static void main(String[] args)
    {
        SEString seString = new SEString();
        InnerSEString innerSEString = seString.new InnerSEString();
    }
}
