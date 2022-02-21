package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-30 10:39
 */
public class HashMap9_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int first = 0; first < n; first++) {
            //判断数字是否重复
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int right = n - 1;
                int left = second + 1;
                while (left < right) {
                    int sum = nums[first] + nums[second] + nums[left] + nums[right];
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        HashMap9_18 test = new HashMap9_18();
        List<List<Integer>> lists = test.fourSum(nums, target);
        //打印方法1：
        Iterator<List<Integer>> it1 = lists.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next().toString());
        }
        //打印方法2：
//        for(List list : lists){
//            System.out.println(list.toString());
//        }
    }
}
