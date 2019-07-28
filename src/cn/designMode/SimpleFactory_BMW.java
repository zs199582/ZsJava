package cn.designMode;

public class SimpleFactory_BMW implements SimpleFactory_Car {
    @Override
    public void getCarBrand() {
        System.out.println("this is a BMW");
    }
}
