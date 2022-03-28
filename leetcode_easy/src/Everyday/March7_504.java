package Everyday;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2022-03-07 14:58
 */
public class March7_504 {
    public String convertToBase7(int num){
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        int remainder = 0;

        while (num != 0){
            remainder = num % 7;
            deque.addFirst(remainder);
            num = num / 7;
        }


        while(!deque.isEmpty()){
            res = res*10;
            res += deque.pop();
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        March7_504 test = new March7_504();
        int num = -7;
        String res = test.convertToBase7(num);
        System.out.println(res);
    }
}
