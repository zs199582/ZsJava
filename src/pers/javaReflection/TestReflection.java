package pers.javaReflection;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

public class TestReflection implements Serializable {
    public void print()
    {
        System.out.println("reflection seccess");
    }
    public static void main(String[]args) throws Exception
    {
        Class reflectionClazz = Class.forName("pers.javaReflection.TestReflection");
        TestReflection reflectionInstance = (TestReflection)reflectionClazz.newInstance();
        Method method = reflectionClazz.getMethod("print");
        method.invoke(reflectionInstance);
    }

}
