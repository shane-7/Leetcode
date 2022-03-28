package preSum;

//一维前缀和

/** 303.区域和检索-数组不可变
 *  用到前缀和
 *  sumRange(i, j) = sums[j+1] − sums[i]
 * @author shkstart
 * @create 2022-03-24 13:46
 */
public class pS01_303 {
    int[] sums;

    public pS01_303(int[] nums) {
        int n = nums.length;
        // 前缀和数组下标从 1 开始，因此设定长度为 n + 1（模板部分）
        sums = new int[n + 1];
        // 预处理除前缀和数组（模板部分）
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        // 求某一段区域和 [i, j] 的模板是 sum[j] - sum[i - 1]（模板部分）
        // 但由于我们源数组下标从 0 开始，因此要在模板的基础上进行 + 1
        left++; right++;
        return sums[right] - sums[left - 1];
    }
}
