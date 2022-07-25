package Array.BinarySearch;


/**
 * 难！,找两个边界
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class BS2_34 {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        //情况1：
        if(leftBorder == -2 || rightBorder == -2){
            return new int[]{-1, -1};
        }
        //情况3：
        if(rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder + 1};
        //情况2：
        return new int[]{-1, -1};

    }

    private static int getLeftBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
                leftBorder = right;
            }else{
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    private static int getRightBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

}
