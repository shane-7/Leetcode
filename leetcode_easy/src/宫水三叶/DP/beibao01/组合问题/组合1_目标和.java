package 宫水三叶.DP.beibao01.组合问题;

/** 494目标和
 * @author shkstart
 * @create 2022-06-07 21:15
 */
public class 组合1_目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if((sum + target)  % 2 != 0) return 0;
        int aim = (sum + target) / 2;
        if(aim < 0) aim = -aim;
        int[] dp = new int[aim + 1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = aim; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[aim];
    }


    public static void main(String[] args) {
        组合1_目标和 test = new 组合1_目标和();
        int res1 = test.findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9}, 0);
        System.out.println(res1);
    }
}
