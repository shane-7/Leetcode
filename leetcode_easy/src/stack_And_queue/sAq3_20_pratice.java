package stack_And_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-10-12 9:31
 */
public class sAq3_20_pratice {
    public boolean isValid(String s) {
        //1.用Deque创建栈
        Deque<Character> deque = new LinkedList<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                deque.push(')');
            }else if(ch == '{'){
                deque.push('}');
            }else if(ch == '['){
                deque.push(']');
            }else {
                //到这里说明碰到了右括号
                if(deque.peek() != ch || deque.isEmpty()){
                    return false;
                }else {
                    deque.pop();
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        sAq3_20_pratice test = new sAq3_20_pratice();
//        String s = "()";
        System.out.println(test.isValid(new String("([)]")));
    }
}
