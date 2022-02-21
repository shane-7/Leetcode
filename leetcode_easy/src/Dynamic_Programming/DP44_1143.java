package Dynamic_Programming;

/** 1143.最长公共子序列
 * @author shkstart
 * @create 2022-02-16 10:58
 */
public class DP44_1143 {
    public int longestCommonSubsequence(String text1, String text2){
        int len1 = text1.length();
        int len2 = text2.length();

        //dp数组初始化
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                dp[i][j] = 0;
            }
        }

        int res = 0;

        //确定遍历顺序：
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(res < dp[i][j])
                    res = dp[i][j];
            }
        }
        return res;

    }
}
