package stack_And_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  20.有效的括号
 *  需要满足左括号必须用相同类型的右括号闭合
 *  左括号必须以正确的顺序闭合
 *
 * @author shkstart
 * @create 2021-10-11 9:12
 */
public class sAq3_20 {
    public boolean isValid(String s){
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.peek() != ch || deque.isEmpty() ) {
                return false;
            }
            //经过以上判断后，说明此时的ch 和 此时栈中的peek()值是一致的，可以将此元素从栈中pop出去
            deque.pop();
        }
        //最后再判断栈是否为空
        return deque.isEmpty();

    }
}
