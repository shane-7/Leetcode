package Array.easy;

/**
 *  209:长度最小的数组
 *
 * @author shkstart
 * @create 2021-07-27 14:32
 */
public class Array4_209 {
    //滑动窗口法(也是用到了双指针)
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum  = 0;
        int i = 0;   //滑动窗口的起始位置
        int subLength = 0;  //滑动窗口的长度
        for(int j = 0; j < nums.length; j++){  //j代表滑动窗口的结束位置
            sum += nums[j];
            //当满足条件时，进入while进行长度判断
            while(sum >= target){
                subLength = j - i + 1;  //在满足sum >= target时更新，滑动窗口的长度
                result = Math.min(subLength, result);
                sum -= nums[i++];      //不断更新滑动窗口的起始位置
            }
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }else{
            return result;
        }
    }

    //暴力解法(两个for循环)
    public int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for(int i = 0; i < nums.length; i++){
            sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= target){
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE? 0 : result;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        Array4_209 test = new Array4_209();
        System.out.println(test.minSubArrayLen(target, nums));
    }
}
