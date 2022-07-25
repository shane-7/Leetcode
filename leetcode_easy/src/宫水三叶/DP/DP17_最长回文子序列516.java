package 宫水三叶.DP;

public class DP17_最长回文子序列516 {
    public static int longestPalindromeSubseq(String s) {
        //dp[i][j]：字符串s在[j, i]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        for(int j = s.length() - 1; j >= 0; j--){
            for(int i = j + 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[s.length() - 1][0];

    }

    public static void main(String[] args) {
        int ans = DP17_最长回文子序列516.longestPalindromeSubseq("cbbd");
        System.out.println(ans);
    }
}
