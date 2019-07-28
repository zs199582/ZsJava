package cn.designMode;

import org.junit.Test;

public class SimpleFactory_Benz implements SimpleFactory_Car {
//    public int wheels = 5;
    @Override
    public void getCarBrand() {
        System.out.println("this is a benz");
    }
    @Test
    public void test(){
        getCarBrand();
    }
}
