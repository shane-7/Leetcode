package Greed;

/** 045. 跳跃游戏II
 *  有难度，需要多做几遍
 * @author shkstart
 * @create 2021-11-24 14:38
 */
public class Greed8_045 {
    public int jump(int[] nums){
        if(nums.length == 1) return 0;
        int curDistance = 0;  //当前覆盖的最远距离下标
        int res = 0;         //记录走的最大步数
        int nextDistance = 0; //下一步覆盖的最远距离下标
        for(int i = 0; i < nums.length; i++){
            //更新下一步覆盖的最远距离下标
            nextDistance = Math.max(i + nums[i], nextDistance);
            if(i == curDistance){   //当i遇到当前覆盖的最远距离下标
                if(curDistance < nums.length - 1){  //如果此时最远距离下标没达到 最后一个位置，则还得继续跑，res++
                    res++;
                    curDistance = nextDistance;
                    if(nextDistance >= nums.length - 1){
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }


}
