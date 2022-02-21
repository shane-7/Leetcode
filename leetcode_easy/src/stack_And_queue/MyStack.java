package stack_And_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shkstart
 * @create 2021-10-08 9:53
 */
public class MyStack {
    Queue<Integer> queue1;   //和栈中保持一样元素的队列
    Queue<Integer> queue2;   //辅助队列

    //初始化数据结构
    public MyStack(){
        queue1 = new LinkedList<>();  //这里用到多态的方法。LinkedList 是Deque接口的实现类，Deque接口继承Queue接口
        queue2 = new LinkedList<>();
    }

    //实现栈的push方法
    public void push(int x){
        queue2.offer(x); //先放在辅助队列中
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;   //交换queue1和queue2，将元素都放到queue1中
    }

    //实现栈的pop方法
    public int pop(){
        return queue1.poll();  //因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    public int top(){
        return queue1.peek();
    }

    public boolean empty(){
        return queue1.isEmpty();
    }
}
