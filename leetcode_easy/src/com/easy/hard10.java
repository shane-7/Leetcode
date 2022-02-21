package com.easy;

/**  第十题：正则表达式匹配（困难）
 * 用到动态规划
 *

 *
 * @author shkstart
 * @create 2021-05-07 13:45
 */
public class hard10 {
    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;  //f[0][0]代表s和p均为空字符串，f[1][1]代表s和p的第一个字符（即在s和p中下标为0的字符）
        for(int i = 0; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(p.charAt(j - 1) == '*'){   //p的第j个字符为*
                    f[i][j] = f[i][j - 2];
                    if(matches(s, p, i, j - 1)) { //匹配s的第i个字符和p的第j-1个字符
                        f[i][j] = f[i][j - 2] || f[i - 1][j];  //p中*前面的字符在s中出现多次或者在s中只出现1次
                    }
                } else{
                    if(matches(s, p, i, j)){
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];

    }

    public boolean matches(String s, String p, int i, int j) {
        if(i == 0){
            return false;
        }
        if(p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        hard10 test = new hard10();
        String s = "mississippi";
        String p = ".*";
        System.out.println(test.isMatch(s, p));
    }

}
