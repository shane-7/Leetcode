package Array.easy;

/** 35.搜索插入位置
 *
 * @author shkstart
 * @create 2021-07-06 22:10
 */
public class easy2 {
    public int searchInsert(int[] nums, int target) {
//        //暴力解法：
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] >= target){
//                return i;
//            }
//        }
//
//        return nums.length;


//        if(target < nums[0])
//            return 0;
//        if(target > nums[nums.length - 1])
//            return nums.length;
//        int left = 0, right = nums.length - 1;
//        while(left < right){
//            int mid = left + (right - left) / 2 + 1;
//            if(nums[mid] == target){
//                return mid;
//            }
//            if(right - left <= 2){
//                return mid;
//            }
//            if(nums[mid] < target){
//                left = mid + 1;
//            } else if(nums[mid] > target){
//                right = mid - 1;
//            }
//        }
//        return 0;


        //二分法
//        int len = nums.length;
//        //特殊判断
//        if(nums[len - 1] < target){
//            return len;
//        }
//        //接下来就是讨论target在区间内的情况 target <= nums[len - 1]
//        int left = 0, right = len - 1;
//        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            if(nums[mid] < target){
//                //下一轮搜索区间是[mid + 1, left]
//                left = mid + 1;
//            }else{
//                //下一轮搜索的区间是[left, mid]
//                right = mid;
//            }
//        }
//        return left;
        //值得一提的是：由于执行到最后 nums[left..right] 里一定存在插入元素的位置，并且退出循环的时候一定有 left == right 成立，
        // 因此直接返回 left 或者 right 均可。

        int n = nums.length;
        int left = 0;
        int right = n - 1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) { // 当left==right，区间[left, right]依然有效
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1
        return right + 1;
    }

    public static void main(String[] args) {
        easy2 test = new easy2();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(test.searchInsert(nums, target));
    }
}
