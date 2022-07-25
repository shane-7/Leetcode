package 宫水三叶.DP;

import java.security.cert.TrustAnchor;

public class DP16_回文子串647 {

    //暴力解法
    public static int countSubstrings(String s) {
        int res = 0;
        for(int i  = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(isBack(s, j, i)){
                    res++;
                }
            }
        }
        return res;
    }

    //动态规划
    public int countSubstrings1(String s){
        int res = 0;
        //1.布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(j) == s.charAt(i)){
                    if(i - j <= 1){
                        dp[i][j] = true;
                        res++;
                    }else if(isBack(s, j + 1, i - 1)){
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }


    public static boolean isBack(String s1, int start, int end){
        for(int i  = start, j = end; i <= j; i++, j--){
            if(s1.charAt(i) != s1.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int res = DP16_回文子串647.countSubstrings("abc");
        System.out.println(res);
    }

}
