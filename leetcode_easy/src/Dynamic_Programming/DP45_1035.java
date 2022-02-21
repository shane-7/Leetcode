package Dynamic_Programming;

/** 1035.不相交的线  直接copy DP44_1143 最长公共子序列
 *   这道题看似比较难，仔细分析求的就是最长公共子序列
 * @author shkstart
 * @create 2022-02-17 8:49
 */
public class DP45_1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

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
                if(nums1[i - 1] == nums2[j - 1])
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
