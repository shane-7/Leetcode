package com.easy;

/** 判断是否是回文数：
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

 * @author shkstart
 * @create 2021-05-06 22:58
 */
public class easy9 {
    public boolean isPalindrome(int x){
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();

        int len = s.length();
        if (len == 1){
            return true;
        }
        boolean flag = true;
        for (int i = 0; i < len / 2; i++){
            if(arr[i] != arr[len - i - 1]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        easy9 test = new easy9();
        int x1 = -121;
        System.out.println(test.isPalindrome(x1));
    }
}
