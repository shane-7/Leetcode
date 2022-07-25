package Template;

/**
 * @author shkstart
 * @create 2022-04-14 23:23
 */
public class test {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) >> 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        test dd = new test();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(dd.searchInsert(nums, target));

    }
}
