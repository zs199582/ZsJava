package cn.javaCollection;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class SECollection {
    @Test
    public void testTreeSet()
    {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(1);
//        Iterator iterator =  treeSet.iterator();
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }
        System.out.println(treeSet);
    }
}
