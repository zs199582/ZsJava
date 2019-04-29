package cn.javaSE;

import java.util.ArrayList;
import java.util.List;

public class SEExtends {
    //如果子类的方法重写了父类的方法，那么子类中该方法的访问级别不允许低于父类的访问级别。
    // 这是为了确保可以使用父类实例的地方都可以使用子类实例，也就是确保满足里氏替换原则。
    public void test(int a)
    {

    }
//    public SEExtends()
//    {
//        System.out.println("fulei");
//    }
    public SEExtends(String str)
    {
        System.out.println(str);
    }
    static
    {
        System.out.println("fuleistaic");
    }
    {
        System.out.println("fuleidaimakuai");
    }
    protected List<Integer> fun()throws Throwable
    {
        return new ArrayList<>();
    }

}
class SonExtends extends SEExtends
{
    /**
     * 当父类有无参构造函数或无构造函数的时候，子类不必须写构造函数，会自动调用父类的constructor
     * 如果父类只有有参构造函数，子类必须写构造，并且使用super调用父类的构造
     */
    public SonExtends()
    {
        super("222");
        System.out.println("zilei");
    }
    public static void main(String[]args)
    {
        SonExtends sonExtends = new SonExtends();
    }
    @Override
    public ArrayList<Integer>fun()throws Exception
    {
        return new ArrayList<>();
    }
}
class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {
}

class D extends B {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        String str1 = "aaa";
        String str2 = "aaa";
        System.out.println(str1==str2);
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b)); // A and A
        System.out.println(a1.show(c)); // A and A
        System.out.println(a1.show(d)); // A and D
        System.out.println(a2.show(b)); // B and A
        System.out.println(a2.show(c)); // B and A
        System.out.println(a2.show(d)); // A and D
        System.out.println(b.show(b));  // B and B
        System.out.println(b.show(c));  // B and B
        System.out.println(b.show(d));  // A and D
        System.out.println(a2.getClass());
        System.out.println(b.getClass());
    }
}
