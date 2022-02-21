package Array.easy;

import java.util.Arrays;

/**27.移除元素
 * @author shkstart
 * @create 2021-07-13 12:05
 */
public class Array2_27 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for(int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if(val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        System.out.println(Arrays.toString(nums));
        return slowIndex;
    }

    public static void main(String[] args) {
        Array2_27 test = new Array2_27();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(test.removeElement(nums, val));
    }
}
