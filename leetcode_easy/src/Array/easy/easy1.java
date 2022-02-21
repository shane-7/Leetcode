package Array.easy;

/**
 * 704.二分查找
 *
 * @author shkstart
 * @create 2021-07-06 21:45
 */
public class easy1 {
    //左闭右闭
    public int serch(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){  //右闭
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    //左闭右开
    public int search1(int[] nums, int target){
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {   //右开
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}