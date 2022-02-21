package stack_And_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-10-12 13:56
 */
public class sAq4_1047_pratice {
    public String removeDuplicats(String s){
        Deque<Character> deque = new LinkedList<>();
        for(char ch : s.toCharArray()){
            //如果deque为空或者栈顶值与此时ch不相等, 则在栈中压入新元素
            if(deque.isEmpty() || deque.peek() != ch){
                deque.push(ch);
            }else {
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            //这里用pollLast()相当于使用了队列，先进先出。不然按照栈的顺序，结果的字符串会相反
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        sAq4_1047_pratice test = new sAq4_1047_pratice();
        System.out.println(test.removeDuplicats(new String("abbaca")));
    }
}
