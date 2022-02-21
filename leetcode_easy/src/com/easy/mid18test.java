package com.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-06 8:51
 */
public class mid18test {
    public List<List<Integer>> forSum(int[] nums, int target){
        ArrayList<List<Integer>> ans1 = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 4){
            return ans1;
        }
        Arrays.sort(nums);

        for(int a = 0; a < len - 3; a++){
            if(a > 0 && nums[a - 1] == nums[a]){   //确保nums[a]改变了
                continue;
            }
            for(int b = a + 1; b < len - 2; b++){
                if(b > a + 1 && nums[b - 1] == nums[b]){
                    continue;
                }

                int c = b + 1, d = len -1;
                while(c < d){
                    if(nums[a] + nums[b] + nums[c] + nums[d] > target){
                        d--;
                    }else if(nums[a] + nums[b] + nums[c] + nums[d] < target){
                        c++;
                    }else{  //如果等于target时
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        ans1.add(list);

                        while(c < d && nums[c] == nums[c + 1]){   //确保nums[c]改变了
                            c++;
                        }
                        while(c < d && nums[d] == nums[d - 1]){  //确保nums[d]改变了
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return ans1;
    }

    public static void main(String[] args) {
        mid18test test = new mid18test();
        int[] nums = {0, 0, 0, 0};
        int target = 0;
        List<List<Integer>> lists = test.forSum(nums, target);
        System.out.println(lists);
    }
}
