package cn.designMode;

/**
 * 单例模式 保证一个类只能实例化一次
 */

import com.sun.javafx.binding.StringFormatter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * 优点：
 *     1.在单例模式中，活动的单例只有一个实例，对单例类的所有实例化得到的都是相同的一个实例。这样就 防止其它对象对自己的实例化，
 *     确保所有的对象都访问一个实例
 *     2.单例模式具有一定的伸缩性，类自己来控制实例化进程，类就在改变实例化进程上有相应的伸缩性。
 *     3.提供了对唯一实例的受控访问。
 *     4.由于在系统内存中只存在一个对象，因此可以 节约系统资源，当 需要频繁创建和销毁的对象时单例模式无疑可以提高系统的性能。
 *     5.允许可变数目的实例。
 *     6.避免对共享资源的多重占用。
 * 缺点：
 *     1.不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态。
 *     2.由于单利模式中没有抽象层，因此单例类的扩展有很大的困难。
 *     3.单例类的职责过重，在一定程度上违背了“单一职责原则”。
 *     4.滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；
 *     如果实例化的对象长时间不被利用，系统会认为是垃圾而被回收，这将导致对象状态的丢失。
 * 使用注意事项：
 *     1.使用时不能用反射模式创建单例，否则会实例化一个新的对象
 *     2.使用懒单例模式时注意线程安全问题
 *     3.单例模式和懒单例模式构造方法都是私有的，因而是不能被继承的，有些单例模式可以被继承（如登记式模式）
 * 适用场景：
 *     单例模式只允许创建一个对象，因此节省内存，加快对象访问速度，因此对象需要被公用的场合适合使用，
 *     如多个模块使用同一个数据源连接对象等等。如：
 *     1.需要频繁实例化然后销毁的对象。
 *     2.创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
 *     3.有状态的工具类对象。
 *     4.频繁访问数据库或文件的对象。
 * 以下都是单例模式的经典使用场景：
 *     1.资源共享的情况下，避免由于资源操作时导致的性能或损耗等。如上述中的日志文件，应用配置。
 *     2.控制资源的情况下，方便资源之间的互相通信。如线程池等。
 * 应用场景举例：
 *     1.外部资源：每台计算机有若干个打印机，但只能有一个PrinterSpooler，以避免两个打印作业同时输出到打印机。内部资源：大多数软件都有一个（或多个）属性文件存放系统配置，这样的系统应该有一个对象管理这些属性文件
 *     2. Windows的TaskManager（任务管理器）就是很典型的单例模式（这个很熟悉吧），想想看，是不是呢，你能打开两个windows task manager吗？ 不信你自己试试看哦~
 *     3. windows的Recycle Bin（回收站）也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
 *     4. 网站的计数器，一般也是采用单例模式实现，否则难以同步。
 *     5. 应用程序的日志应用，一般都何用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
 *     6. Web应用的配置对象的读取，一般也应用单例模式，这个是由于配置文件是共享的资源。
 *     7. 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。数据库软件系统中使用数据库连接池，主要是节省打开或者关闭数据库连接所引起的效率损耗，这种效率上的损耗还是非常昂贵的，因为何用单例模式来维护，就可以大大降低这种损耗。
 *     8. 多线程的线程池的设计一般也是采用单例模式，这是由于线程池要方便对池中的线程进行控制。
 *     9. 操作系统的文件系统，也是大的单例模式实现的具体例子，一个操作系统只能有一个文件系统。
 *     10. HttpApplication 也是单位例的典型应用。熟悉ASP.Net(IIS)的整个请求生命周期的人应该知道HttpApplication也是单例模式，所有的HttpModule都共享一个HttpApplication实例.
 */
public class Singletion {
    private Singletion(){}
    //static应该是类加载的时候就会初始化  每次singleton类被加载的时候都会初始化
    private static Singletion singletion = new Singletion();
    public static Singletion getInstance()
    {
        return singletion;
    }
}

/**
 * 第二种单例模式
 */
class TheSecondSingleton{
    private TheSecondSingleton(){}
    private static TheSecondSingleton theSecondSingleton = null;
    public static synchronized TheSecondSingleton getInstance()
    {
        //只有第一次使用该类的时候会初始化 不用每次都生成一个对象
        if(theSecondSingleton == null)
        {
            theSecondSingleton = new TheSecondSingleton();
        }
        return theSecondSingleton;
    }
}
class TheThirdSingleton{
    private TheThirdSingleton(){};
    private static Object object = new Object();
    private static TheThirdSingleton theThirdSingleton;
    public TheThirdSingleton getInstance(){
        //两次判断是否等于null
        if(theThirdSingleton == null){
            synchronized(object){
                if(theThirdSingleton == null)
                    theThirdSingleton = new TheThirdSingleton();
            }
        }
        return theThirdSingleton;
    }
}
