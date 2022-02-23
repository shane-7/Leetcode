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

            if(count <= 0) count = 0; //这一步很妙

            //这两步if结合起来，既能保证如果nums全为负数的情况下，maxSum能得到那个最大的负数
            //又能保证在正负数交叉的nums中让maxSum相加的数为正数
        }
        return maxSum;
    }
}
