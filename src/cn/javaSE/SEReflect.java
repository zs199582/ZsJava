package cn.javaSE;

import cn.javaCollection.SECollection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SEReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SECollection seCollection = new SECollection();
        String string = SECollection.class.toString().substring(6);
        Class clazz = Class.forName(string);
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Method method = clazz.getMethod("test");
        method.invoke(instance);
    }
}
