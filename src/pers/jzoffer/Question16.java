package pers.jzoffer;

import org.junit.Test;

public class Question16 {
    //数值的整数次方
    //这个题注意的点就是特殊值 指数值为负数的情况，base为0的情况。考虑周全
    protected double power(double base,int exponent){
        //exponent为负数或者0
        if(exponent == 0) return 1;
        if((Math.abs(base-0.0)<1e-6d)&&exponent<0) throw new RuntimeException();
        double target = 1;
        for(int i = 0;i<Math.abs(exponent);i++)
            target = target*base;
        if(exponent<0)
            return 1/target;
        else return target;
    }
    //还有另一个解法，实现公式
    protected double power2(double base, int exponent){
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
//        if((Math.abs(base-0.0)<1e-6d)&&exponent<0) throw new RuntimeException();
        double target = 1;
        target = power2(base,exponent>>1);
        target*=target;
        if((exponent& 0x01)==1)
            target = target*base;
        return target;
    }
    @Test
    public void test(){
        System.out.println(power2(2,-5));
    }
}
