package 宫水三叶.DP;

public class DP8_最长递增子序列300 {
    public static int lengthOfLIS(int[] nums) {
        //dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        int result = 0;
        //递推公式：
//        位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
//        所以：if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
//        注意这里不是要dp[i] 与 dp[j] + 1进行比较，而是我们要取dp[j] + 1的最大值。
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > result) result = dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int res = DP8_最长递增子序列300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
    }



}
