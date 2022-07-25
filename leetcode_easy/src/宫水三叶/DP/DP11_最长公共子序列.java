package 宫水三叶.DP;

public class DP11_最长公共子序列 {
    public static int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i <= text1.length(); i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= text2.length(); j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if((text1.charAt(i - 1) == text2.charAt(j - 1))){
                    dp[i][j] = dp[i- 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        int res = DP11_最长公共子序列.longestCommonSubsequence("abcde", "bce");
        System.out.println(res);

    }
}
