package Dynamic_Programming;

/**
 *  背包最大容量为 sum / 2
 *  j 代表目前的背包容量
 *  物品i的重量、价值都是 nums[i]
 * @author shkstart
 * @create 2021-12-07 19:49
 */
public class DP13_416_test {
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        //1.确定do数组的初始化
        int[] dp = new int[10001];

        //2.开始遍历
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if(dp[target] == target){
            return true;
        }else{
            return false;
        }
    }

}
