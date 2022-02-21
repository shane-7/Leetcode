package Array.easy;

/** 283移动零
 * @author shkstart
 * @create 2021-07-14 9:48
 */
public class Array2_283 {
    public void moveZeros(int[] nums){
        int Index = 0;
        //把不为0的数先放前面
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[Index++] = nums[i];
            }
        }
        for(int j = Index; j < nums.length; j++){
            nums[j] = 0;
        }
    }
}
