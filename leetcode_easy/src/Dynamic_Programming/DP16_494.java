package Dynamic_Programming;

/**
 * @author shkstart
 * @create 2021-12-08 15:42
 */
public class DP16_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        //以下情况无解：
        if((target + sum) % 2 == 1) return 0;
        //有解则：
        int left = (target + sum) / 2;
        int bagSize = 0;

        //注意这里因为target是整数，所以left可能为负数
        if(left < 0){
            bagSize = -left;
        }else{
            bagSize = left;
        }
        //题意转换为 装满容量为left的包，有几种方法

        //1.确定dp数组的下标以及含义：
        //dp[j]: 表示装满容量为j的包，有dp[j]种方法

        //2.递推公式为：

        //3.初始化
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = bagSize; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
