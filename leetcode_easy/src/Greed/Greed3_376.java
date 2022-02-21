package Greed;

// 值得做好几遍，对于边界问题的考虑以及怎么会想到用curDiff 和 preDiff
/** 376.摆动序列
 *  目前用的是贪心算法， 等学到动态规划想想接下来怎么用动规来解题
 * @author shkstart
 * @create 2021-11-23 19:23
 */
public class Greed3_376 {
    public int wiggleMaxLength(int[] nums){
        if(nums.length <= 1) return nums.length; //特殊情况判断
        int result = 1;
        int curDiff = 0;
        int preDiff = 0;
        for(int i = 0; i < nums.length - 1; i++){
            curDiff = nums[i + 1] - nums[i];
            if(curDiff > 0 && preDiff <= 0 || curDiff <= 0 && preDiff > 0){
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
