package 宫水三叶.前缀和;

/** 1480.一维数组的动态和
 * @author shkstart
 * @create 2022-04-14 23:42
 */
public class preSum2_1480 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] += sum[i - 1] + nums[i - 1];
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sum[i + 1];
        }
        return res;
    }
}
