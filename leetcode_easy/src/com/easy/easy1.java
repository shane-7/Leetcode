package com.easy;

import java.util.Arrays;

/**
 * 1.两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

 你可以按任意顺序返回答案。

 * @author shkstart
 * @create 2021-03-09 17:41
 */
public class easy1 {
    public int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        easy1 sum = new easy1();
        int[] result = sum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}


