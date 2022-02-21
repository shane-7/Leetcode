package com.easy;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-05-26 16:41
 */
public class mid16test {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int first = 0; first < n; first++){
            int second = first + 1, third = n - 1;
            while(second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum > target){
                    third--;
                }else if(sum < target){
                    second++;
                }else if(sum == target){
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        mid16test test = new mid16test();
        int[] nums = {0, 2, 1, -3};
        int target = 1;    //预期结果为0
        System.out.println(test.threeSumClosest(nums, target));
    }
}
