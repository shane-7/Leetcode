package Template;

/**
 * @author shkstart
 * @create 2022-04-14 22:36
 */
public class 前缀和 {
    public void func(int[] nums){
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
}
