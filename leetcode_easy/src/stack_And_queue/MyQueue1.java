package stack_And_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-10-16 18:05
 */
class MyQueue1{
    Deque<Integer> deque = new LinkedList<>();
    void add(int value){
        while(!deque.isEmpty() && value > deque.getLast()){ //直到将要加入的值比队尾元素值大或者队列为空
            deque.removeLast();
        }
        deque.addLast(value);
    }

    void poll(int value){
        //弹出元素时，如果前一个滑动窗口的第一个元素等于此时队列中的最大值时(队列出口处元素)，则将队出口元素弹出
        if(!deque.isEmpty() && value == deque.getFirst()){
            deque.removeFirst(); //de
        }

    }

    int peek(){
        return deque.peek();
    }
}
