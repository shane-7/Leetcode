package Template;

/**
 * @author shkstart
 * @create 2022-04-02 10:27
 */

//二分查找根据区间定义有两种写法：
    //1.左闭右闭 [left, right]
    //2.左闭右开 [left, right)
public class 二分查找 {
    //二分查找的第一种写法：左闭右闭
//    while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
//    if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1
    public int search1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2; //防止溢出 等同于(left + right) / 2
            if(nums[mid] > target){
                right = mid - 1;      //target在左区间
            }else if (nums[mid] < target){
                left = mid + 1;      //target在右区间
            }else {
                return mid;         //找到target的索引
            }

        }
        return -1;
    }

    //写法2：左闭右开
//    while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
//    if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，而寻找区间是左闭右开区间，
//    所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
    public int search2(int[] nums, int target){
        int left = 0;
        int right = nums.length; // 定义target在左闭右开的区间里，即：[left, right)
        while(left < right){     // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;      // target 在左区间，在[left, middle)中
            }else if (nums[mid] < target){
                left = mid + 1;    // target 在右区间，在[middle + 1, right)中
            }else {
                return mid;
            }
        }
        return -1;
    }
}
