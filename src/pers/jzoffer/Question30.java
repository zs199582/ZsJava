package pers.jzoffer;

import java.util.Stack;

public class Question30 {
    public static void main(String[] args)
    {
        Question30 question30 = new Question30();
        question30.push(3);
        question30.push(4);
        question30.push(1);
        System.out.println(question30.top());
    }
    public Stack mainStack = new Stack();
    public Stack supStack  = new Stack();
    public void push(int node) {
        if(supStack.isEmpty())
        {
            supStack.push(node);
            mainStack.push(node);
        }
        else if(node<(int)supStack.peek())
            supStack.push(node);
        mainStack.push(node);
    }

    public void pop() {
        if(supStack.isEmpty()) return;
        if(mainStack.peek()==supStack.peek())
        {
            supStack.pop();
        }
        mainStack.pop();
        String str = "sss";
        str.length();
    }

    public int top() {
        return (int)mainStack.peek();
    }

    public int min() {
        return (int)supStack.peek();
    }
}
