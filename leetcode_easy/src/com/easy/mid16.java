package com.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 16.最接近的的三数之和
 * @author shkstart
 * @create 2021-05-26 15:35
 */
public class mid16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
//        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> sites = new HashMap<>();
        int sum = 0;
        //枚举first
        for(int first = 0; first < n; ++first){
            //首先要确定和上一次枚举的的数不相同，相同则结束此次循环
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            //指针初始化
            int third = n - 1;
            for(int second = first + 1; second < n; ++second){
                third = n - 1;
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }

                while (second < third){
                    sum = nums[first] + nums[second] + nums[third];
                    int res = Math.abs(sum - target);
                    third--;
                    //保证target与三数之和的差是不重复的，永远在最前面
                    if(sites.containsKey(res)){
                        continue;
                    }
                    sites.put(res, sum);
                }

                if(second == third){
                    continue;
                }
            }
        }
        //获取map中的键集，转换成数组并排序，得到最小的键（也就是最小的差），即得到对应的键值（最接近target的三数之和）
        Set set=sites.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        int result = sites.get(arr[0]);

        return result;
    }

    public static void main(String[] args) {
        mid16 test = new mid16();
        int[] nums = new int[]{0, 2, 1, -3};  //预期结果为0
        int target = 1;
        System.out.println(test.threeSumClosest(nums, target));
    }
}
