package Array.easy;

/**
 * @author shkstart
 * @create 2022-04-02 11:18
 */
public class Array3_977test {
    public int[] sortedSquares(int[] nums) {
        if(nums.length == 1){
            return new int[]{nums[0] * nums[0]};
        }
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        for(int i = 0, j = nums.length-1; i <= j;){
            if(nums[i] * nums[i] < nums[j] * nums[j]){
                res[k--] = nums[j]*nums[j];
                j--;
            }else {
                res[k--] = nums[i]*nums[i];
                i++;
            }
        }
        return res;
    }
}
