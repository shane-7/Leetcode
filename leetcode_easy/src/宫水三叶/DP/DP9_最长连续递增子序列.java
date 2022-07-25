package 宫水三叶.DP;

/**
 * 674
 */
public class DP9_最长连续递增子序列 {
    public static int findLengthOfLCIS(int[] nums) {
        //dp[i]：以下标i为结尾的数组的连续递增的子序列长度为dp[i]
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }

        int result = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] > nums[i]){
                dp[i + 1] = dp[i] + 1;
            }
            result = Math.max(dp[i + 1], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int res = DP9_最长连续递增子序列.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(res);
    }
}
