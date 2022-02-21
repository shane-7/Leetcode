package Array.easy;

/** 数组第二章的这一类型为：在原数组上移动数组，并大多使用双指针法。
 * 26题
 * @author shkstart
 * @create 2021-07-14 9:23
 */
public class Array2_26 {
    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int p = 0, q = 1;
        while (q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
