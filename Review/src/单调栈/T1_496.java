package 单调栈;

import java.util.HashMap;
import java.util.Stack;

public class T1_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        int[] greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        //存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            //判断个子高矮
            while(!s.isEmpty() && s.peek() <= nums[i]){
                //矮个起开，反正也被挡着了
                s.pop();
            }
            //num[i]身后的更大元素
            res[i] = s.isEmpty()? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
