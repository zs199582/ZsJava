package pers.jzoffer;

class Question2solu1 {
    //实现单例模式
    //实现方式1 只适用于单线程环境
    //构造函数私有
    public Question2solu1(){
    }
    private static Question2solu1 instance=null;
    public Question2solu1 getInstance()
    {
        if(instance==null)
            instance = new Question2solu1();
        return instance;
    }
}
class Question2solu2{
    //实现方式2
    //解决实现方式1中，多线程如果同时运行到instance==null这一行，会创建多个实例对象。
    private static Question2solu2 instance = null;
    //锁对象
    private final Object syncObj = new Object();
    private Question2solu2(){
    }
    public Question2solu2 getInstance(){
        synchronized(syncObj){
            if(instance==null)
                instance = new Question2solu2();
        }
        return instance;
    }
}
class Question2solu3{
    //单例模式实现方式3
    //方式2中，每次调用getInstance方法都要加锁，非常耗时
    private static Question2solu3 instance = null;
    private final Object syncObj = new Object();
    private Question2solu3(){

    }
    public Question2solu3 getInstance(){
        if(instance==null){
            synchronized(syncObj){
                if(instance == null)
                    instance = new Question2solu3();
            }
        }
        return instance;
    }
}
class Question2solu4{
    //类静态变量在类加载的时候就初始化完毕，因此只会生成一个对象
    //饿汉式
    private static Question2solu4 instance = new Question2solu4();
    private Question2solu4(){

    }
    public Question2solu4 getInstance(){
        return instance;
    }
}

