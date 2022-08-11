package 单调栈;

import java.util.Arrays;
import java.util.Stack;

public class T0 {
    public static int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            //判断个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }
            res[i] = s.isEmpty()? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ans = T0.nextGreaterElement(new int[]{2, 1, 2, 4, 3});
        System.out.println(Arrays.toString(ans));
    }



}
