package cn.javaThread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteTest {
    //读写锁测试
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        try {

        }
        finally {
            System.out.println("2");
        }
        System.out.println("1");
    }
}
