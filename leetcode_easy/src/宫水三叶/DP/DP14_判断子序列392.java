package 宫水三叶.DP;

public class DP14_判断子序列392 {
    public boolean isSubsequence(String s, String t) {
        //dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for(int i = 1; i <= t.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                if(t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[t.length()][s.length()] == s.length();
    }

    //双指针
    public static boolean isSubsequence1(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        boolean ans = DP14_判断子序列392.isSubsequence1("ace", "abcde");
        System.out.println(ans);
    }
}
