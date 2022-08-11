package 单调栈;

import java.util.Arrays;
import java.util.Stack;

public class T2_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        //这里放元素索引，而不是元素
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            //判断个子高矮
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            //得到索引间距
            res[i] = s.isEmpty()? 0 : (s.peek() - i);
            //将索引入栈，而不是元素
            s.push(i);
        }
        return res;
    }

}
