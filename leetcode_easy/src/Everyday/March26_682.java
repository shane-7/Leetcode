package Everyday;

import java.util.Deque;
import java.util.LinkedList;

//注意下面的"==" 应该用equals.

/** 682.棒球比赛
 * @author shkstart
 * @create 2022-03-26 15:03
 */
public class March26_682 {
    public int calPoints(String[] ops) {
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < ops.length; i++){
            if(ops[i] == "+") {
                int a = deque.pop();
                int b = deque.peekFirst();
                deque.addFirst(a);
                deque.addFirst(a + b);

            }else if(ops[i] == "D"){
                int d = deque.peekFirst();
                deque.addFirst(d * 2);
            }else if(ops[i] == "C"){
                deque.pop();
            }else {
                //如果字符串为数字，则压入栈中
                deque.addFirst(Integer.valueOf(ops[i]));
            }
        }
        int res = 0;
        while (!deque.isEmpty()){
            res += deque.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        March26_682 test = new March26_682();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int res = test.calPoints(ops);
        System.out.println(res);
//        String s = "1";
//        int re = Integer.parseInt(s);
//        System.out.println(re);

    }
}
