package Greed;

/** 53.最大子序和
 * @author shkstart
 * @create 2021-11-23 21:03
 */
public class Greed4_053 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            if(count > maxSum) maxSum = count;

            if(count <= 0) count = 0; //这一步没有想到
        }
        return maxSum;
    }
}
