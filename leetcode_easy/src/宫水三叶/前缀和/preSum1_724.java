package 宫水三叶.前缀和;

/** 724.寻找数组的中心下标
 * @author shkstart
 * @create 2022-04-14 23:42
 */
public class preSum1_724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        int left_sum = 0;
        for(int i = 0; i < n; i++){
            sum -= nums[i];
            if(left_sum == sum){
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}
