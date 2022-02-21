package Dynamic_Programming;

/** 392.判断子序列
 * @author shkstart
 * @create 2022-02-17 10:37
 */
public class DP47_392 {
    public boolean isSubsequence(String s, String t) {
        //1.确定dp数组以及下标的含义：
        //dp[i][j]表示以下标为i-1为结尾的字符串s，和以下标为j-1为结尾的字符串t，相同的子序列的长度为dp[i][j]

        int res = 0;
        //2.dp数组的初始化
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                //3.确定递推公式
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
                if(res < dp[i][j])
                    res = dp[i][j];
            }
        }
        if(res == s.length()){
            return true;
        }else {
            return false;
        }
    }
}
