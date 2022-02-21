package com.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * @author shkstart
 * @create 2021-07-02 8:17
 */
public class mid18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int a = 0; a < len - 3; ++a) {
            if (a > 0 && nums[a] == nums[a - 1]) {          //确保nums[a]改变了
                continue;
            }
            for (int b = a + 1; b < len - 2; ++b) {          //确保nums[b]改变了
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int c = b + 1, d = len - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        c++;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        ans.add(list);

                        while (c < d && nums[c] == nums[c + 1]) {  //确保nums[c]改变了
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d]) {   //确保nums[d]改变了
                            d--;
                        }
                        c++;
                        d--;
                    }
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int target = 0;
        mid18 test = new mid18();
        List<List<Integer>> result = test.fourSum(nums, target);
        System.out.println(result);
    }
}
