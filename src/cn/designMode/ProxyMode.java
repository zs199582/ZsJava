package cn.designMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 *
 * 一）静态代理
 *
 * 实现方式：
 *
 * a） 为真实类和代理类提供的公共接口或抽象类。（租房）
 *
 * b） 真实类，具体实现逻辑，实现或继承a。（房主向外租房）
 *
 * c） 代理类，实现或继承a，有对b的引用，调用真实类的具体实现。（中介）
 *
 * d） 客户端，调用代理类实现对真实类的调用。（租客租房）
 *
 * 二）动态代理
 *
 * 实现方式：
 *
 * a） 公共的接口（必须是接口，因为Proxy类的newproxyinstance方法的第二参数必须是个接口类型的Class）
 *
 * b） 多个真实类，具体实现的业务逻辑。
 *
 * c）  代理类，实现InvocationHandler接口，提供Object成员变量，和Set方法，便于客户端切换。
 *
 * d） 客户端，获得代理类的实例，为object实例赋值，调用Proxy.newproxyinstance方法在程序运行时生成继承公共接口的实例，
 * 调用相应方法，此时方法的执行由代理类实现的Invoke方法接管。
 *
 * jdk动态代理使用的局限性：
 * 通过反射类Proxy和InvocationHandler回调接口实现的jdk动态代理，要求委托类必须实现一个接口，但事实上并不是所有类都有接口，
 * 对于没有实现接口的类，便无法使用该方方式实现动态代理。
 */
public class ProxyMode {

}
interface BuyHouse
{
    public void buy();
}
class BuyHouseImpl implements BuyHouse
{
    public void buy()
    {
        System.out.println("买房子了");
    }
}
class BuyHouseProxy implements BuyHouse
{
    BuyHouse buyHouse;
    BuyHouseProxy(BuyHouse buyHouse)
    {
        this.buyHouse = buyHouse;
    }
    public void buy()
    {
        System.out.println("攒钱");
        buyHouse.buy();
        System.out.println("我真牛逼");
    }
}
class Test
{

    public static void main(String[]args) {
        //静态代理测试
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buy();
        //动态代理测试
        BuyHouse buyHouseDynamic = new BuyHouseImpl();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(buyHouseDynamic);
        //dynamicProxyHandler.invoke(buyHouseProxy,"buyHouse",null);
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class},new DynamicProxyHandler(buyHouse));
    }
}

/**
 * 动态代理类
 * 在动态代理中我们不再需要再手动的创建代理类，我们只需要编写一个动态处理器就可以了。真正的代理对象由JDK再运行时为我们动态的来创建。
 */
class DynamicProxyHandler implements InvocationHandler
{
    private Object object;
    public DynamicProxyHandler(final Object object)
    {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("攒钱");
        Object result = method.invoke(proxy,args);
        System.out.println("我真牛逼");
        return result;
    }
}