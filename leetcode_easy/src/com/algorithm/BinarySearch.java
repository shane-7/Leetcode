package com.algorithm;

/**   二分查找法
 * @author shkstart
 * @create 2021-04-15 22:49
 */
public class BinarySearch {
    public int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else  if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
