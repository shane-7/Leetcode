package stack_And_queue;

import java.util.Deque;
import java.util.LinkedList;

/** 1.先判断是否是数字（不是操作符就是数字，在逐符号计算）
 * @author shkstart
 * @create 2021-10-13 14:04
 */
public class sAq5_150_practice {
    public int evalRPN (String[] tokens){
        Deque<Integer> deque = new LinkedList<>();
        for(String token : tokens){
            if(!isOperation(token)){
                deque.addFirst(Integer.valueOf(token));
            }else if(token == "+"){
                deque.push(deque.pop() + deque.pop());
            }else if(token == "-"){
                deque.push(-deque.pop() + deque.pop());
            }else if(token == "*"){
                deque.push(deque.pop() * deque.pop());
            }else {
                int num1 = deque.pop();
                int num2 = deque.pop();
                deque.push(num2 / num1);
            }
        }
        return deque.pop();
    }

    public boolean isOperation(String s){
        return (s.length() == 1 && (s.charAt(0) < '0' || s.charAt(0) > '9'));
    }

    public static void main(String[] args) {
        sAq5_150_practice test = new sAq5_150_practice();
        System.out.println(test.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }
}
