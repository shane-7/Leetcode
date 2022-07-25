package 宫水三叶.DP;

//思路：把环拆开，按照Ⅰ版本来计算
public class DP4_打家劫舍Ⅱ {
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //dp[i]:考虑下标i（包含i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp1 = new int[nums.length];  //左边
        int[] dp2 = new int[nums.length];  //右边

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for(int i = 2; i < nums.length - 1; i++){
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        for(int i = 3; i < nums.length; i++){
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
        int res = DP4_打家劫舍Ⅱ.rob(new int[]{2, 3, 2});
        System.out.println(res);
    }

}
