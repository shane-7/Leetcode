package Array.easy;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-07-16 17:53
 */
public class Array3_977 {

    //暴力解法：
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    //双指针法：
    /*
    具体解法看官方题解
     */
    public int[] sortedSquares1(int[] nums) {
        int len = nums.length;
        int negative = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] < 0){
                negative = i;
            }else{
                break;
            }
        }

        int[] ans = new int[len];
        int index = 0, i = negative, j = negative + 1;
        while(i >= 0 || j < len){
            if(i < 0){            //边界情况1：i < 0 说明左半部分已经遍历完成，只需继续右半部分遍历完成即可
                ans[index] = nums[j] * nums[j];
                j++;
            }else if(j == len) {  //边界情况2：j == len 说明右半部分已经遍历完成，只需继续左半部分遍历完成即可
                ans[index] = nums[i] * nums[i];
                i--;
            }else if(nums[i] * nums[i] < nums[j] * nums[j]){
                //情况1；nums[i]方 比 num[j]方 小
                ans[index] = nums[i] * nums[i];
                i--;
            }else {
                //情况2：nums[i]方 比 nums[j]方 大
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        Array3_977 test = new Array3_977();
        System.out.println(Arrays.toString(test.sortedSquares1(nums)));
    }

}
