package doublepointer;

import java.util.Arrays;

/**27.移除元素
 * @author shkstart
 * @create 2021-09-15 23:14
 */
public class dp1_27 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for(int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if(val != nums[fastIndex]){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        System.out.println(Arrays.toString(nums));
        return slowIndex;
    }
    public static void main(String[] args) {
        dp1_27 test = new dp1_27();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(test.removeElement(nums, val));
    }
}
