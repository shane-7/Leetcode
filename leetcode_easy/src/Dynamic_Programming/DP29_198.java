package Dynamic_Programming;

/** 198.打家劫舍
 * @author shkstart
 * @create 2021-12-21 8:56
 */
public class DP29_198 {
    public int rob(int[] nums) {
        //特殊情况判断
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //1.确定dp[i]数组以及下标的含义：
        //考虑下标i(包含i)以内的房屋，最多可以偷窃的金额为dp[i]

        //2.确定递推公式
        //决定dp[i]的因素在于第i房间偷还是不偷
        //2.1如果偷第i间房，那么第i-1间房一定是不考虑的，dp[i] = dp[i - 2] + nums[i]
        //2.2如果不偷第i间房，那么就要考虑第i - 1间房， dp[i] = dp[i - 1]
        //所以递推公式为： dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        //3.dp数组的初始化
        //从递推公式可知，dp数组由i - 1 和 i - 2决定, 所以要初始化dp[0] 和dp[1]；
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //确定遍历顺序
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);   //2.确定递推公式
        }

        return dp[nums.length - 1];
    }
}
