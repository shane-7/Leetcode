package Dynamic_Programming;

/** 674.最长连续递增序列
 * @author shkstart
 * @create 2022-02-15 16:52
 */
public class DP42_674 {
    public int findLengthOfLCIS(int[] nums) {
        //特殊情况考虑
        if(nums.length == 0){
            return 1;
        }

        //1.dp[i]的定义：表示i之前包括i的最长连续递增序列
        //dp[i]的初始化
        int[] dp = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }

        int res = 1;

        //2.状态转移方程：
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                if(res < dp[i]){
                    res = dp[i];
                }
            }else {
                dp[i] = 1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        DP42_674 test = new DP42_674();
        int[] nums = new int[]{1,3,5,4,7};
        int res = test.findLengthOfLCIS(nums);
        System.out.println(res);

    }
}
