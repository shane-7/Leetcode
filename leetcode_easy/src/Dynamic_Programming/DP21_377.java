package Dynamic_Programming;

/** 377.组合总和Ⅳ (mid)
 * @author shkstart
 * @create 2021-12-14 9:55
 */
public class DP21_377 {
    public int combinationSum4(int[] nums, int target) {
        //1.确定dp数组以及下标的含义：
        // dp[j]表示数字总和为j的排列组合数

        //3.dp数组的初始化
        int[] dp = new int[target + 1];
        dp[0] = 1;

        //4.确定遍历顺序：先背包后物品
        for(int j = 0; j <= target; j++){
            for(int i = 0; i < nums.length; i++){
                if(j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]]; //2.确定递推公式，因为是完全背包排列问题，所以先背包后物品
                }
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
        DP21_377 test = new DP21_377();
        int[] nums = {1, 2, 3};
        int target = 4;
        int res = test.combinationSum4(nums, target);
        System.out.println(res);

    }
}
