package stack_And_queue;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-10-06 15:41
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    //初始化数据结构
    public MyQueue(){
        stack1 = new Stack<>();   //负责进栈
        stack2 = new Stack<>();   //负责出栈
    }

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        dumpStack1();
        return stack2.pop();
    }

    public int peek(){
        dumpStack1();
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void dumpStack1(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

}
