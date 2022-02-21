package com.easy;

/** 最长回文子串， 回文：可以正着读，可以反着读
 * @author shkstart
 * @create 2021-04-20 21:27
 */
public class easy5 {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxlen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        //左下角先填
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //只要dp[i][j] == true成立，就表示s[i..j]是回文，此时记录回文长度和起始位置
                if(dp[i][j] && j - i + 1 > maxlen){
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxlen);
    }





    public static void main(String[] args) {
        String s = "ab";
        easy5 test = new easy5();
        System.out.println(test.longestPalindrome(s));
    }
}
