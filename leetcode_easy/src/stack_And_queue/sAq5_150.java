package stack_And_queue;

import java.util.Deque;
import java.util.LinkedList;



/** 150.逆波兰表达式求值
 *  tokens中的每个元素都是单个字符的字符串
 * @author shkstart
 * @create 2021-10-11 15:20
 */
public class sAq5_150 {
    public int evalRPN(String[] tokens){
        Deque<Integer> deque = new LinkedList<>();
        for(String token : tokens){
            char c = token.charAt(0);
            //先判断是否是数字?
            if(!isOpe(token)){
                deque.addFirst(Integer.valueOf(token));
            }else if(c == '+'){
                deque.push(deque.pop() + deque.pop());
            }else if(c == '-'){
                deque.push(- deque.pop() + deque.pop());
            }else if(c == '*'){
                deque.push(deque.pop() * deque.pop());
            }else {
                //这里的操作符为除
                int num1 = deque.pop();
                int num2 = deque.pop();
                deque.push(num2/num1);
            }
        }
        return deque.pop();

    }

    //判断是否是操作符?
    private boolean isOpe(String s){
       return (s.length() == 1 && s.charAt(0) < '0' ||s.charAt(0) > '9');
    }
    private int stoi(String s){
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
        sAq5_150 test = new sAq5_150();
        System.out.println(test.evalRPN(new String[]{"4", "13", "5", "/", "+"}));

    }

}
