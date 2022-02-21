package Dynamic_Programming;

/** 30.打家劫舍Ⅱ
 *  此题比前一个多了个成环，那么就要想着怎么去环，去按照原来的打家劫舍来求
 *  把首和尾分开来求
 *
 * @author shkstart
 * @create 2021-12-21 17:54
 */
public class DP30_213 {
    public int rob(int[] nums) {
        //特殊情况判断
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int result1 = robRange(nums, 0, nums.length - 2); // 情况二：考虑包含首元素，不包含尾元素
        int result2 = robRange(nums, 1, nums.length - 1); // 情况三：考虑包含尾元素，不包含首元素
        return Math.max(result1, result2);
    }

    public int robRange(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i <= end; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4};
        DP30_213 test = new DP30_213();
        int res = test.rob(nums);
        System.out.println(res);

    }
}
