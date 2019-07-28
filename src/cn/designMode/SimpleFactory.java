package cn.designMode;

import org.junit.Test;

public class SimpleFactory {
    //简单工厂模式
    //提供实现了同一个接口的不同类的实例的get方法
    public SimpleFactory_Car getCar(String carName){
        if(carName.equals("BMW"))
            return new SimpleFactory_BMW();
        else if(carName.equals("Benz"))
            return new SimpleFactory_Benz();
        else return null;
    }

    //工厂模式
    //就是奔驰车要提供一个奔驰车工厂，宝马车要提供一个宝马车工厂
    //
    //抽象工厂模式
    @Test
    public void test(){
       SimpleFactory_Car car = getCar("Benz");
       car.getCarBrand();
    }
}
