package com.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和，要等于0
 * @author shkstart
 * @create 2021-05-25 23:37
 */
public class mid15 {
    public List<List<Integer>> threeSum(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);  //将nums排序，更好确定指针位置
        ArrayList<List<Integer>> ans = new ArrayList<>();
        //定义三个指针，开始找数
        for(int first = 0; first < len; ++first){
            //首先要确定和上一次枚举的的数不相同，相同则结束此次循环
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }

            //将指针初始化
            int third = len - 1;
            int target = -nums[first];
            for(int second = first + 1; second < len; ++second){
                //还是要保证和上一次枚举的数不重复
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target){
                    //如果相加大于target, 说明third指向的数太大了，要向左移
                    --third;
                }

                //还要注意，两个指针会不会重合
                if(second == third){
                    break;
                }

                if(nums[second] + nums[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        mid15 test = new mid15();
        System.out.println(test.threeSum(nums));
    }
}
