package Array.easy;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-07-26 21:42
 */
public class test977 {
    //暴力解法：
    public int[] sortedSquares2 (int[] nums){
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    //官方 双指针解法
    public int[] sortedSquares3 (int[] nums){
        //step1:先找到负数与非负数临界点
        int len = nums.length;

        int nes = 0; //临界Index
        for(int i = 0; i < len; i++){
            if(nums[i] < 0){
                nes = i;
            }else{
                break;
            }
        }

        int[] ans = new int[len];
        int index = 0, i = nes, j = nes + 1;
        while (i >= 0 || j < len){
            //边界情况1：左半部分先遍历结束(i < 0)，则继续将右半部分遍历完即可
            if(i < 0){
                ans[index++] = nums[j] * nums[j];
                j++;
            }else if(j == len){
                //边界情况2: 右半部分先遍历结束(j == len), 则继续将左半部分遍历完即可
                ans[index++] = nums[i] * nums[i];
                i--;
            } else if(nums[i] * nums[i] < nums[j] * nums[j]){
                //情况1：nums[i]方 小于 nums[j]方
                ans[index++] = nums[i] * nums[i];
                i--;
            } else {
                //情况2：nums[i]方 大于等于 nums[j]方
                ans[index++] = nums[j] * nums[j];
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        test977 test = new test977();
        System.out.println(Arrays.toString(test.sortedSquares3(nums)));
    }

}
