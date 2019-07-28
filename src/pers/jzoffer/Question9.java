package pers.jzoffer;

import java.util.Stack;

public class Question9<T> {
    //两个栈实现队列
    private Stack<T> stack1;
    private Stack<T> stack2;
    //尾部插入
    public void appendTail(T data){
        stack1.push(data);
    }
    //头部删除节点
    //这里将stack1的数据压进stack2，弹出之后，不用把stack2全部再导回stack1中，
    //因为这时stack2中数据的顺序已经是队列的数据了
    public T deleteHead(){
        if(stack1.isEmpty()&&stack2.isEmpty()) return null;
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
