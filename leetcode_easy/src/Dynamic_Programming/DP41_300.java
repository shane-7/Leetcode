package Dynamic_Programming;

/**
 * @author shkstart
 * @create 2022-01-26 19:51
 */
public class DP41_300 {
    public int lengthOfLIS(int[] nums) {

        //特殊情况考虑
        if(nums.length == 1){
            return 1;
        }

        //1.dp[i]的定义：dp[i]表示i之前包括i的最长递增子序列
        int[] dp = new int[nums.length];

        //dp[i]的初始化
        for (int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        //2.状态转移方程：位置i的最长递增子序列等于j从0到i-1各个位置的最长递增子序列+1的最大值
        // 解释：在遍历j从0到i-1的过程中，只要nums[j]有小于nums[i]的情况，那么就取max(dp[i], dp[j] + 1)
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if(dp[i] > result) result = dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DP41_300 test = new DP41_300();
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = test.lengthOfLIS(nums);
        System.out.println(res);
    }
}
