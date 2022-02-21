package test;

/** 376.摆动序列
 * @author shkstart
 * @create 2021-11-24 9:55
 */
public class Greed3 {
    public int wiggleMaxLength(int[] nums){
        int res = 1;
        int curDiff = 0;
        int preDiff = 0;
        //特殊情况处理：当nums.length == 1 时， res = 1；
        if(nums.length <= 1) return res;

        for(int i = 0; i < nums.length - 1; i++){
            curDiff = nums[i + 1] - nums[i];
            if(curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0){
                preDiff = curDiff;
                res++;
            }
        }
        return res;
    }
}
