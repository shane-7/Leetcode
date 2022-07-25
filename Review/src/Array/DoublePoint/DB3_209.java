package Array.DoublePoint;

import java.awt.font.NumericShaper;
import java.util.logging.Level;

/** 滑动窗口
 *
 * 长度最小的子数组
 */
public class DB3_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length - 1];
        int fast = 0, slow = 0;
        int ans = nums.length;
        int sum = 0;
        for(; fast < nums.length; fast++){
            sum += nums[fast];
            while(sum >= target){
                ans = Math.min(ans, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int res = DB3_209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
    }

}
