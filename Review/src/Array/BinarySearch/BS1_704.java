package Array.BinarySearch;

/**
 * 二分查找
 */
public class BS1_704 {
    public int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + right - left;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) left = mid + 1;
            if(nums[mid] > target) right = mid - 1;
        }
        return -1;
    }

}
