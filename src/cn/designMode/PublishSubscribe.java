package cn.designMode;

import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * 观察者模式
 * 应该叫发布/订阅模式更好
 * 观察者模式是对象的行为模式，又叫发布-订阅(Publish/Subscribe)模式、模型-视图(Model/View)模式、
 * 源-监听器(Source/Listener)模式或从属者(Dependents)模式。
 *
 * 实现方式：
 *
 * a） 角色抽象类（提供对观察者的添加，删除和通知功能）。
 *
 * b） 角色具体类，实现a，维护一个c的集合（对角色抽象类的实现）。
 *
 * c）  观察者抽象类（被角色通知后实现的方法）。
 *
 * d） 观察者实现类，实现c（多个）。
 *
 * 注：JDK提供了对观察者模式的支持，使用Observable类和Observer接口
 */
public class PublishSubscribe {
    public static void main(String[]args)
    {
        //创建一个微信服务器
        WechatServer wechatServer = new WechatServer();
        wechatServer.setMessage("服务器初始化");
        for(int i = 0;i<10;i++)
        {
            wechatServer.registerObserver(new WechatUser(String.valueOf(i)));
        }
        wechatServer.publish();
    }
}
//观察者接口
interface IObservable
{
    public void update(String message);
}
//发布者接口
interface IPublishable
{
    //注册一个观察者
    public void registerObserver(IObservable observer);
    //移除一个观察者
    public void removeObserver(IObservable observer);
    //发布信息
    public void publish();
}
class WechatUser implements IObservable
{
    private String userName;
    private String message;
    public WechatUser(String userName){this.userName = userName;}
    @Override
    public void update(String message) {
        this.message = message;
        System.out.println(userName+":"+this.message);
    }
}
class WechatServer implements IPublishable
{
    //保存用户信息
    private List<IObservable> list;

    public void setMessage(String message) {
        this.message = message;
    }

    //信息
    private String message;
    public WechatServer()
    {
        list = new ArrayList<IObservable>();
    }
    @Override
    public void registerObserver(IObservable observer) {
        this.list.add(observer);
    }

    @Override
    public void removeObserver(IObservable observer) {
        if(!list.isEmpty())
        this.list.remove(observer);
    }

    @Override
    public void publish(){
        for (IObservable observer:this.list
             ) {
            observer.update(this.message);
        }
    }
}